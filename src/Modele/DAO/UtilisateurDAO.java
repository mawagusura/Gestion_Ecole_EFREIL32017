package Modele.DAO;

import Modele.JavaBean.Privilege;
import Modele.JavaBean.Utilisateur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UtilisateurDAO extends DAO<Utilisateur> {

    public UtilisateurDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Utilisateur obj) {
        return false;
    }

    @Override
    public boolean delete(Utilisateur obj) {
        return false;
    }

    @Override
    public boolean update(Utilisateur obj) {
        return false;
    }

    @Override
    public Utilisateur find(int id) {
        try {

            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Utilisateur WHERE id = " + id);

            // Exploitation du résultat
            return rs2utilisateur(resultSet);

        } catch (SQLException e) {
            System.err.println("Erreur SQL.");
        }

        return null;
    }

    public Utilisateur find(String mail) {
        try {

            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Utilisateur WHERE mail = \"" + mail + "\"");

            // Exploitation du résultat
            return rs2utilisateur(resultSet);

        } catch (SQLException e) {
            System.err.println("Erreur SQL.");
        }

        return null;
    }

    private Utilisateur rs2utilisateur(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                Utilisateur u = new Utilisateur();
                u.setId_utilisateur(resultSet.getInt("id_utilisateur"));
                u.setMail(resultSet.getString("mail"));
                u.setNom(resultSet.getString("nom"));
                u.setPrenom(resultSet.getString("prenom"));
                u.setHash_mdp(resultSet.getString("hash_mdp"));

                PrivilegeDAO p = new PrivilegeDAO(this.connect);
                u.setId_privilege(resultSet.getInt("id_privilege"));
                return u;
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL.");
        }

        return null;
    }
}
