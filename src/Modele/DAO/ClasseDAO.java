package Modele.DAO;

import Modele.JavaBean.Classe;

import java.sql.*;
import java.util.ArrayList;

public class ClasseDAO extends DAO<Classe> {

    public ClasseDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Classe obj) {
        return false;
    }

    @Override
    public boolean delete(Classe obj) {
        try {
            // Préparation du statement
            Statement stmnt = connect.createStatement();
            String query = "DELETE FROM Classe WHERE id_classe = " + obj.getId_classe();

            // Exécution
            stmnt.executeUpdate(query);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Classe obj) {
        try {
            // Préparation du statement
            String query = "update Classe set " +
                    "nom = ?," +
                    "id_niveau = ?," +
                    "where id_classe = " + obj.getId_classe();

            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setString(1, obj.getNom());
            preparedStmt.setInt(2, obj.getNiveau().getId_niveau());
            // Exécution
            preparedStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Classe find(int id) {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Classe WHERE id_classe = " + id);

            // Récupération des DAOs nécessaires pour les relations
            NiveauDAO niveauDAO = new NiveauDAO(connect);

            // Exploitation du résultat
            while (resultSet.next()) {
                Classe c = new Classe();
                c.setId_classe(resultSet.getInt("id_classe"));
                c.setNiveau(niveauDAO.find(resultSet.getInt("id_niveau")));
                c.setNom(resultSet.getString("nom"));
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
    public ArrayList<Classe> findAll() {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Classe");

            // Arraylist des classes
            ArrayList<Classe> classes = new ArrayList<Classe>();

            // Récupération des DAOs nécessaires pour les relations
            NiveauDAO niveauDAO = new NiveauDAO(connect);

            // Exploitation du résultat
            while (resultSet.next()) {
                Classe c = new Classe();
                c.setId_classe(resultSet.getInt("id_classe"));
                c.setNiveau(niveauDAO.find(resultSet.getInt("id_niveau")));
                c.setNom(resultSet.getString("nom"));
                classes.add(c);
            }
            return classes;
        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur SQL");
        }

        // Si on trouve rien, on renvoie null
        return null;
    }
}
