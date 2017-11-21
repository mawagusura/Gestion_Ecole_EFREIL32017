package Modele;

import Modele.Javabean.Privilege;
import Modele.Javabean.Utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {

    // Pour récupérer le résultat d'une requete
    private static ResultSet dbRequest(String request) {
        try {

            Statement stmnt;
            stmnt = DBConnector.getInstance().createStatement();
            return stmnt.executeQuery(request);

        } catch (SQLException e) {
            System.err.println("Erreur SQL : \"" + request + "\" : la requete n'a pas abouti.");
            return null;
        }
    }


    // =======================================
    // Méthodes de récupération d'utilisateurs
    // =======================================

    // Retrourne des utilisateurs à partir d'un ResultSet
    private static ArrayList<Utilisateur> rs2utilisateur(ResultSet resultSet) {
        try {

            ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
            while (resultSet.next()) {
                Utilisateur u = new Utilisateur();
                u.setId_utilisateur(resultSet.getInt("id_utilisateur"));
                u.setMail(resultSet.getString("mail"));
                u.setNom(resultSet.getString("nom"));
                u.setPrenom(resultSet.getString("prenom"));
                u.setHash_mdp(resultSet.getString("hash_mdp"));
                u.setPrivilege(getPrivilege(resultSet.getInt("id_privilege")));
                utilisateurs.add(u);
            }
            return utilisateurs;

        } catch (SQLException e) {
            System.err.println("Erreur SQL.");
            return null;
        }
    }

    public static Utilisateur getUtilisateur(String mail) {
        try {

            ResultSet rs = dbRequest("SELECT * FROM Utilisateur WHERE mail = \"" + mail + "\"");
            Utilisateur u = rs2utilisateur(rs).get(0);
            return u;

        } catch (NullPointerException e) {
            return null;
        }
    }

    public static Utilisateur getUtilisateur(String nom, String prenom) {
        try {

            ResultSet rs = dbRequest("SELECT * FROM Utilisateur WHERE nom = \"" + nom + "\" and prenom = \"" + prenom + "\"");
            Utilisateur u = rs2utilisateur(rs).get(0);
            return u;

        } catch (NullPointerException e) {
            return null;
        }
    }

    // ======================================
    // Méthodes de récupération de privilèges
    // ======================================

    private static Privilege getPrivilege(int id) throws SQLException {
        ResultSet rs = dbRequest("SELECT * FROM privilege WHERE id_privilege = " + id);
        if (rs.last()) {
            return null;
        }
        while(rs.next()) {
            Privilege p = new Privilege();
            p.setId_privilege(rs.getInt("id_privilege"));
            p.setLibelle(rs.getString("libelle"));
            return p;
        }
        return null;
    }

}
