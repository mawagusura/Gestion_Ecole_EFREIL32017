package Modele.DAO;

import Modele.JavaBean.Matiere;
import Modele.JavaBean.Suit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        return false;
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

    // Retourne une liste des relations matière / élève (classe Suit)
    public ArrayList<Suit> findMatieres(int id_eleve) {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM suit WHERE matricule = " + id_eleve);

            // Arraylist des relatoins matières / élèves
            ArrayList<Suit> matieres = new ArrayList<Suit>();

            // Exploitation du résultat
            while (resultSet.next()) {
                Suit s = new Suit();
                s.setMatricule(resultSet.getInt("matricule"));
                s.setId_matiere(resultSet.getInt("id_matiere"));
                s.setCoefficient(resultSet.getFloat("coefficient"));
                matieres.add(s);
            }
        } catch(SQLException e) {
            System.err.println("Erreur SQL");
        }
        return null;
    }
}
