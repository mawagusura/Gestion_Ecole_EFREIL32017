package Modele.DAO;

import Modele.JavaBean.Note;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NoteDAO extends DAO<Note> {

    public NoteDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Note obj) {
        return false;
    }

    @Override
    public boolean delete(Note obj) {
        return false;
    }

    @Override
    public boolean update(Note obj) {
        return false;
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

            // Exploitation du résultat
            while (resultSet.next()) {
                Note n = new Note();
                n.setMatricule(resultSet.getInt("matricule"));
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

            // Exploitation du résultat
            while (resultSet.next()) {
                Note n = new Note();
                n.setMatricule(resultSet.getInt("matricule"));
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

            // Exploitation du résultat
            while (resultSet.next()) {
                Note n = new Note();
                n.setMatricule(resultSet.getInt("matricule"));
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

            // Exploitation du résultat
            while (resultSet.next()) {
                Note n = new Note();
                n.setMatricule(resultSet.getInt("matricule"));
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
