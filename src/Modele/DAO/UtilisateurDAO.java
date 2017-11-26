package Modele.DAO;

import Modele.JavaBean.Privilege;
import Modele.JavaBean.Utilisateur;

import java.sql.*;
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
        try {
            // Préparation du statement
            Statement stmnt = connect.createStatement();
            String query = "DELETE FROM Utilisateur WHERE id_utilisateur = " + obj.getId_utilisateur();

            // Exécution
            stmnt.executeUpdate(query);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Utilisateur obj) {
        try {
            // Préparation du statement
            String query = "update Utilisateur set " +
                    "mail = ?," +
                    "nom = ?," +
                    "prenom = ?," +
                    "hash_mdp = ?," +
                    "id_privilege = ?," +
                    "where id_utilisateur = " + obj.getId_utilisateur();

            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setString(1, obj.getMail());
            preparedStmt.setString(2, obj.getNom());
            preparedStmt.setString(3, obj.getPrenom());
            preparedStmt.setString(4, obj.getHash_mdp());
            preparedStmt.setInt(5, obj.getPrivilege().getId_privilege());

            // Exécution
            preparedStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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
            e.printStackTrace();
            System.err.println("Erreur SQL.");
        }

        return null;
    }

    @Override
    public ArrayList<Utilisateur> findAll() {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Utilisateur");

            // ArrayList des utilisateurs
            ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

            while (resultSet.next()) {
                Utilisateur u = new Utilisateur();
                u.setId_utilisateur(resultSet.getInt("id_utilisateur"));
                u.setMail(resultSet.getString("mail"));
                u.setNom(resultSet.getString("nom"));
                u.setPrenom(resultSet.getString("prenom"));
                u.setHash_mdp(resultSet.getString("hash_mdp"));

                PrivilegeDAO p = new PrivilegeDAO(this.connect);
                u.setPrivilege(p.find(resultSet.getInt("id_privilege")));
                utilisateurs.add(u);
            }
            return utilisateurs;
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
                u.setPrivilege(p.find(resultSet.getInt("id_privilege")));
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur SQL.");
        }

        return null;
    }
}
