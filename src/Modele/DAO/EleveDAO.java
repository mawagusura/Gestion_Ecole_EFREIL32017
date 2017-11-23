package Modele.DAO;

import Modele.JavaBean.Eleve;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EleveDAO extends DAO<Eleve>{

    public EleveDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Eleve obj) {
        return false;
    }

    @Override
    public boolean delete(Eleve obj) {
        return false;
    }

    @Override
    public boolean update(Eleve obj) {
        return false;
    }

    @Override
    public Eleve find(int matricule) {
        try {

            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Eleve WHERE matricule = \"" + matricule + "\"");

            // Exploitation du résultat
            while (resultSet.next()) {
                Eleve e = new Eleve();
                e.setMatricule(resultSet.getInt("matricule"));
                e.setDate_inscription(resultSet.getDate("date_inscription"));
                e.setDate_naissance(resultSet.getDate("date_naissance"));
                e.setEtablissement_precedent(resultSet.getString("etablissement_precedent"));
                e.setId_classe(resultSet.getInt("id_classe"));
                e.setId_coord(resultSet.getInt("id_coord"));
                e.setId_sante(resultSet.getInt("id_sante"));
                e.setSexe(resultSet.getInt("sexe"));
                e.setPrenom(resultSet.getString("prenom"));
                e.setNom(resultSet.getString("nom"));
                e.setVille_naissance(resultSet.getString("ville_naissance"));
                e.setPays_naissance(resultSet.getString("pays_naissance"));
                return e;
            }

        } catch (SQLException e) {
            System.err.println("Erreur SQL.");
        }

        return null;
    }
}
