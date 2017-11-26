package Modele.DAO;

import Modele.JavaBean.Eleve;
import Modele.JavaBean.Matiere;

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
}
