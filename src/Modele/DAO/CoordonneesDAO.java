package Modele.DAO;

import Modele.JavaBean.Coordonnees;

import java.sql.*;
import java.util.ArrayList;

public class CoordonneesDAO extends DAO<Coordonnees> {

    public CoordonneesDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Coordonnees obj) {
        return false;
    }

    @Override
    public boolean delete(Coordonnees obj) {
        try {
            // Préparation du statement
            Statement stmnt = connect.createStatement();
            String query = "DELETE FROM Coordonnees WHERE id_coord = " + obj.getId_coord();

            // Exécution
            stmnt.executeUpdate(query);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Coordonnees obj) {
        try {
            // Préparation du statement
            String query = "update Coordonnees set " +
                    "adresse = ?," +
                    "ville = ?," +
                    "tel_fixe = ?," +
                    "tel_mobile = ?," +
                    "mail = ? " +
                    "where id_coord = " + obj.getId_coord();

            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setString(1, obj.getAdresse());
            preparedStmt.setString(2, obj.getVille());
            preparedStmt.setString(3, obj.getTel_fixe());
            preparedStmt.setString(4, obj.getTel_mobile());
            preparedStmt.setString(5, obj.getMail());
            // Exécution
            preparedStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Coordonnees find(int id) {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Coordonnees WHERE id_coord = " + id);

            // Exploitation du résultat
            while (resultSet.next()) {
                Coordonnees c = new Coordonnees();
                c.setId_coord(resultSet.getInt("id_coord"));
                c.setAdresse(resultSet.getString("adresse"));
                c.setMail(resultSet.getString("mail"));
                c.setTel_fixe(resultSet.getString("tel_fixe"));
                c.setTel_mobile(resultSet.getString("tel_mobile"));
                c.setVille(resultSet.getString("ville"));
                return c;
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur SQL");
        }

        // Si on trouve rien, on renvoie null
        return null;
    }

    @Override
    public ArrayList<Coordonnees> findAll() {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Coordonnees");

            // Arraylist des coordonnees
            ArrayList<Coordonnees> coordonnees = new ArrayList<Coordonnees>();

            // Exploitation du résultat
            while (resultSet.next()) {
                Coordonnees c = new Coordonnees();
                c.setId_coord(resultSet.getInt("id_coord"));
                c.setAdresse(resultSet.getString("adresse"));
                c.setMail(resultSet.getString("mail"));
                c.setTel_fixe(resultSet.getString("tel_fixe"));
                c.setTel_mobile(resultSet.getString("tel_mobile"));
                c.setVille(resultSet.getString("ville"));
                coordonnees.add(c);
            }
            return coordonnees;
        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur SQL");
        }

        // Si on trouve rien, on renvoie null
        return null;
    }
}
