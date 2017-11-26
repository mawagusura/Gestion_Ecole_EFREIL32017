package Modele.DAO;

import Modele.JavaBean.Responsable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ResponsableDAO extends DAO<Responsable> {
    
    public ResponsableDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Responsable obj) {
        return false;
    }

    @Override
    public boolean delete(Responsable obj) {
        return false;
    }

    @Override
    public boolean update(Responsable obj) {
        return false;
    }

    @Override
    public Responsable find(int id_resp) {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Responsable WHERE id_responsable = " + id_resp);

            // Exploitation du résultat
            while (resultSet.next()) {
                Responsable r = new Responsable();
                r.setId_responsable(resultSet.getInt("id_responsable"));
                r.setId_eleve(resultSet.getInt("id_eleve"));
                r.setAdresse(resultSet.getString("adresse"));
                r.setMail(resultSet.getString("mail"));
                r.setTelephone(resultSet.getString("telephone"));
                r.setPrenom(resultSet.getString("prenom"));
                r.setNom(resultSet.getString("nom"));
                return r;
            }
        } catch(SQLException e) {
            System.err.println("Erreur SQL");
        }

        // Si on trouve rien, on renvoie null
        return null;
    }

    public ArrayList<Responsable> findByEleve(int id_eleve) {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Responsable WHERE id_eleve = " + id_eleve);

            // Création d'une arraylist qui contiendra les responsables de l'élève
            ArrayList<Responsable> responsables= new ArrayList<Responsable>();

            // Exploitation du résultat
            while (resultSet.next()) {
                Responsable r = new Responsable();
                r.setId_responsable(resultSet.getInt("id_responsable"));
                r.setId_eleve(resultSet.getInt("id_eleve"));
                r.setAdresse(resultSet.getString("adresse"));
                r.setMail(resultSet.getString("mail"));
                r.setTelephone(resultSet.getString("telephone"));
                r.setPrenom(resultSet.getString("prenom"));
                r.setNom(resultSet.getString("nom"));
                responsables.add(r);
            }

            return responsables;
        } catch(SQLException e) {
            System.err.println("Erreur SQL");
        }

        // Si on trouve rien, on renvoie null
        return null;
    }
}