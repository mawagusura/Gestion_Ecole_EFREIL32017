package Modele.DAO;

import Modele.JavaBean.Note;

import java.sql.*;
import java.util.ArrayList;

public class NoteDAO extends DAO<Note> {

    public NoteDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Note obj) {
        try {
            // Préparation du statement
            String query = "INSERT INTO Note (matricule, id_matiere, note) VALUES (?, ?, ?) ";

            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setFloat(1, obj.getCoefficient());
            preparedStmt.setInt(2, obj.getEleve().getMatricule());
            preparedStmt.setInt(3, obj.getMatiere().getId_matiere());
            preparedStmt.setFloat(4, obj.getNote());

            // Exécution
            preparedStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Note obj) {
        try {
            // Préparation du statement
            Statement stmnt = connect.createStatement();
            String query = "DELETE FROM Note WHERE id_note = " + obj.getId_note();

            // Exécution
            stmnt.executeUpdate(query);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Note obj) {
        try {
            // Préparation du statement
            String query = "update Note set " +
                    "coefficient = ?," +
                    "matricule = ?," +
                    "id_matiere = ?," +
                    "note = ?," +
                    "where id_note = " + obj.getId_note();

            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setFloat(1, obj.getCoefficient());
            preparedStmt.setInt(2, obj.getEleve().getMatricule());
            preparedStmt.setInt(3, obj.getMatiere().getId_matiere());
            preparedStmt.setFloat(4, obj.getNote());

            // Exécution
            preparedStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Note find(int id) {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Note WHERE id = " + id);

            // Récupération des DAOs nécessaires pour les relations
            MatiereDAO matiereDAO = new MatiereDAO(connect);
            EleveDAO eleveDAO = new EleveDAO(connect);

            // Exploitation du résultat
            while (resultSet.next()) {
                Note n = new Note();
                n.setEleve(eleveDAO.find(resultSet.getInt("matricule")));
                n.setMatiere(matiereDAO.find(resultSet.getInt("id_matiere")));
                n.setCoefficient(resultSet.getFloat("coefficient"));
                n.setId_note(resultSet.getInt("id_note"));
                n.setNote(resultSet.getFloat("note"));
                return n;
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
            System.err.println("Erreur SQL");
        }
        return null;
    }

    @Override
    public ArrayList<Note> findAll() {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Note");

            // Arraylist des notes de l'élève
            ArrayList<Note> notes = new ArrayList<Note>();

            // Récupération des DAOs nécessaires pour les relations
            MatiereDAO matiereDAO = new MatiereDAO(connect);
            EleveDAO eleveDAO = new EleveDAO(connect);

            // Exploitation du résultat
            while (resultSet.next()) {
                Note n = new Note();
                n.setEleve(eleveDAO.find(resultSet.getInt("matricule")));
                n.setMatiere(matiereDAO.find(resultSet.getInt("id_matiere")));
                n.setCoefficient(resultSet.getFloat("coefficient"));
                n.setId_note(resultSet.getInt("id_note"));
                n.setNote(resultSet.getFloat("note"));
                notes.add(n);
            }
            return notes;
        } catch(SQLException ex) {
            ex.printStackTrace();
            System.err.println("Erreur SQL");
        }
        return null;
    }

    public Note find(int id_eleve, int id_matiere) {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Note WHERE matricule = " + id_eleve +
                    " and id_matiere = " + id_matiere);

            // Récupération des DAOs nécessaires pour les relations
            MatiereDAO matiereDAO = new MatiereDAO(connect);
            EleveDAO eleveDAO = new EleveDAO(connect);

            // Exploitation du résultat
            while (resultSet.next()) {
                Note n = new Note();
                n.setEleve(eleveDAO.find(resultSet.getInt("matricule")));
                n.setMatiere(matiereDAO.find(resultSet.getInt("id_matiere")));
                n.setCoefficient(resultSet.getFloat("coefficient"));
                n.setId_note(resultSet.getInt("id_note"));
                n.setNote(resultSet.getFloat("note"));
                return n;
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
            System.err.println("Erreur SQL");
        }
        return null;
    }

    public ArrayList<Note> findByEleve(int id_eleve) {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Note WHERE matricule = " + id_eleve);

            // Arraylist des notes de l'élève
            ArrayList<Note> notes = new ArrayList<Note>();

            // Récupération des DAOs nécessaires pour les relations
            MatiereDAO matiereDAO = new MatiereDAO(connect);
            EleveDAO eleveDAO = new EleveDAO(connect);

            // Exploitation du résultat
            while (resultSet.next()) {
                Note n = new Note();
                n.setEleve(eleveDAO.find(resultSet.getInt("matricule")));
                n.setMatiere(matiereDAO.find(resultSet.getInt("id_matiere")));
                n.setCoefficient(resultSet.getFloat("coefficient"));
                n.setId_note(resultSet.getInt("id_note"));
                n.setNote(resultSet.getFloat("note"));
                notes.add(n);
            }
            return notes;
        } catch(SQLException ex) {
            ex.printStackTrace();
            System.err.println("Erreur SQL");
        }
        return null;
    }
}
