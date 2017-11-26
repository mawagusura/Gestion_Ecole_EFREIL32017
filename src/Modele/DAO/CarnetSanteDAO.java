package Modele.DAO;

import Modele.JavaBean.Carnet_sante;

import java.sql.*;
import java.util.ArrayList;

public class CarnetSanteDAO extends DAO<Carnet_sante> {

    public CarnetSanteDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Carnet_sante obj) {
        return false;
    }

    @Override
    public boolean delete(Carnet_sante obj) {
        return false;
    }

    @Override
    public boolean update(Carnet_sante obj) {
        try {
            // Préparation du statement
            String query = "update Carnet_sante set " +
                    "medecin_traitement = ?," +
                    "telephone_medecin = ?," +
                    "vaccinations = ?," +
                    "allergies = ?," +
                    "remarques = ? " +
                    "where id_sante = " + obj.getId_sante();

            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setString(1, obj.getMedecin_traitement());
            preparedStmt.setString(2, obj.getTelephone_medecin());
            preparedStmt.setInt(3, obj.getVaccinations());
            preparedStmt.setString(4, obj.getAllergies());
            preparedStmt.setString(5, obj.getRemarques());

            // Exécution
            preparedStmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Carnet_sante find(int id) {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Carnet_sante WHERE id_sante = " + id);

            // Exploitation du résultat
            while (resultSet.next()) {
                Carnet_sante s = new Carnet_sante();
                s.setId_sante(resultSet.getInt("id_sante"));
                s.setMedecin_traitement(resultSet.getString("medecin_traitement"));
                s.setRemarques(resultSet.getString("remarques"));
                s.setTelephone_medecin(resultSet.getString("telephone_medecin"));
                s.setVaccinations(resultSet.getInt("allergies"));
                s.setAllergies(resultSet.getString("allergies"));
                return s;
            }
        } catch(SQLException e) {
            System.err.println("Erreur SQL");
        }

        // Si on trouve rien, on renvoie null
        return null;
    }

    @Override
    public ArrayList<Carnet_sante> findAll() {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Carnet_sante");

            // Arraylist contenant tous les carnets de santé
            ArrayList<Carnet_sante> carnets = new ArrayList<Carnet_sante>();

            // Exploitation du résultat
            while (resultSet.next()) {
                Carnet_sante s = new Carnet_sante();
                s.setId_sante(resultSet.getInt("id_sante"));
                s.setMedecin_traitement(resultSet.getString("medecin_traitement"));
                s.setRemarques(resultSet.getString("remarques"));
                s.setTelephone_medecin(resultSet.getString("telephone_medecin"));
                s.setVaccinations(resultSet.getInt("allergies"));
                s.setAllergies(resultSet.getString("allergies"));
                carnets.add(s);
            }
            return carnets;
        } catch(SQLException e) {
            System.err.println("Erreur SQL");
        }

        // Si on trouve rien, on renvoie null
        return null;
    }
}
