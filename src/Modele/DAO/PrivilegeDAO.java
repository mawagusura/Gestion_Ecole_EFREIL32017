package Modele.DAO;

import Modele.JavaBean.Privilege;

import java.sql.*;
import java.util.ArrayList;

public class PrivilegeDAO extends DAO<Privilege> {
    public PrivilegeDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Privilege obj) {
        return false;
    }

    @Override
    public boolean delete(Privilege obj) {
        try {
            // Préparation du statement
            Statement stmnt = connect.createStatement();
            String query = "DELETE FROM privilege WHERE id_privilege = " + obj.getId_privilege();

            // Exécution
            stmnt.executeUpdate(query);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Privilege obj) {
        try {
            // Préparation du statement
            String query = "update privilege set " +
                    "libelle = ?," +
                    "where id_privilege = " + obj.getId_privilege();

            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setString(1, obj.getLibelle());

            // Exécution
            preparedStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Privilege find(int id) {

        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM privilege WHERE id_privilege = " + id);

            // Exploitation du résultat
            while (resultSet.next()) {
                Privilege p = new Privilege();
                p.setId_privilege(resultSet.getInt("id_privilege"));
                p.setLibelle(resultSet.getString("libelle"));
                return p;
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur SQL");
        }

        // Si on trouve rien, on renvoie null
        return null;
    }

    @Override
    public ArrayList<Privilege> findAll() {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM privilege");

            // Arraylist de privileges
            ArrayList<Privilege> privileges = new ArrayList<Privilege>();

            // Exploitation du résultat
            while (resultSet.next()) {
                Privilege p = new Privilege();
                p.setId_privilege(resultSet.getInt("id_privilege"));
                p.setLibelle(resultSet.getString("libelle"));
                privileges.add(p);
            }
            return privileges;
        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur SQL");
        }

        // Si on trouve rien, on renvoie null
        return null;
    }
}
