package Modele.DAO;

import Modele.JavaBean.Eleve;
import Modele.JavaBean.Matiere;

import java.sql.*;
import java.util.ArrayList;

public class MatiereDAO extends DAO<Matiere> {

    public MatiereDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Matiere obj) {
        return false;
    }

    @Override
    public boolean delete(Matiere obj) {
        return false;
    }

    @Override
    public boolean update(Matiere obj) {
        try {
            // Préparation du statement
            String query = "update Matiere set " +
                    "nom_matiere = ?," +
                    "where id_matiere = " + obj.getId_matiere();

            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setString(1, obj.getNom_matiere());

            // Exécution
            preparedStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Matiere find(int id) {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Matiere WHERE id_matiere = " + id);

            // Exploitation du résultat
            while (resultSet.next()) {
                Matiere m = new Matiere();
                m.setId_matiere(resultSet.getInt("id_matiere"));
                m.setNom_matiere(resultSet.getString("nom_matiere"));
                return m;
            }
        } catch(SQLException e) {
            System.err.println("Erreur SQL");
        }
        return null;
    }

    @Override
    public ArrayList<Matiere> findAll() {
        try {

            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery(
                    "SELECT * FROM Matiere"
            );

            // Array contenant les eleves
            ArrayList<Matiere> matieres = new ArrayList<Matiere>();

            // Exploitation du résultat
            while (resultSet.next()) {
                Matiere m = new Matiere();
                m.setId_matiere(resultSet.getInt("id_matiere"));
                m.setNom_matiere(resultSet.getString("nom_matiere"));
                matieres.add(m);
            }

            return matieres;

        } catch (SQLException ex) {
            System.err.println("Erreur SQL.");
        }

        return null;
    }

    public ArrayList<Matiere> findByEleve(int id_eleve) {
        try {

            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery(
                    "SELECT * FROM Matiere WHERE id_matiere IN (" +
                            "SELECT id_matiere FROM Note WHERE matricule = "+ id_eleve +")"
            );

            // Array contenant les eleves
            ArrayList<Matiere> matieres = new ArrayList<Matiere>();

            // Exploitation du résultat
            while (resultSet.next()) {
                Matiere m = new Matiere();
                m.setId_matiere(resultSet.getInt("id_matiere"));
                m.setNom_matiere(resultSet.getString("nom_matiere"));
                matieres.add(m);
            }

            return matieres;

        } catch (SQLException ex) {
            System.err.println("Erreur SQL.");
        }

        return null;
    }

    public ArrayList<Matiere> findByClasse(int id_classe) {
        try {

            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery(
                    "SELECT * FROM Matiere WHERE id_matiere IN (" +
                            "SELECT id_matiere FROM Note WHERE matricule IN( " +
                            "SELECT matricule FROM Eleve " +
                            "WHERE id_classe = " + id_classe +
                            "))"
            );

            // Array contenant les eleves
            ArrayList<Matiere> matieres = new ArrayList<Matiere>();

            // Exploitation du résultat
            while (resultSet.next()) {
                Matiere m = new Matiere();
                m.setId_matiere(resultSet.getInt("id_matiere"));
                m.setNom_matiere(resultSet.getString("nom_matiere"));
                matieres.add(m);
            }

            return matieres;

        } catch (SQLException ex) {
            System.err.println("Erreur SQL.");
        }

        return null;
    }
}
