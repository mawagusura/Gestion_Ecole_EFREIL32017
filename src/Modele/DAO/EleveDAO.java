package Modele.DAO;

import Modele.JavaBean.Eleve;
import Modele.JavaBean.Matiere;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

            // Récupération des DAOs nécessaires pour les relations
            ClasseDAO classeDAO = new ClasseDAO(connect);
            CoordonneesDAO coordonneesDAO = new CoordonneesDAO(connect);
            CarnetSanteDAO carnetSanteDAO = new CarnetSanteDAO(connect);

            // Exploitation du résultat
            while (resultSet.next()) {
                Eleve e = new Eleve();
                e.setMatricule(resultSet.getInt("matricule"));
                e.setDate_inscription(resultSet.getDate("date_inscription"));
                e.setDate_naissance(resultSet.getDate("date_naissance"));
                e.setEtablissement_precedent(resultSet.getString("etablissement_precedent"));
                e.setClasse(classeDAO.find(resultSet.getInt("id_classe")));
                e.setCoord(coordonneesDAO.find(resultSet.getInt("id_coord")));
                e.setSante(carnetSanteDAO.find(resultSet.getInt("id_sante")));
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

    public ArrayList<Eleve> findByMatiere(int id_matiere) {
        try {

            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery(
                    "SELECT * FROM Eleve WHERE matricule IN (" +
                            "SELECT matricule FROM suit WHERE id_matiere = "+ id_matiere +")"
            );

            // Récupération des DAOs nécessaires pour les relations
            ClasseDAO classeDAO = new ClasseDAO(connect);
            CoordonneesDAO coordonneesDAO = new CoordonneesDAO(connect);
            CarnetSanteDAO carnetSanteDAO = new CarnetSanteDAO(connect);

            // Array contenant les eleves
            ArrayList<Eleve> eleves = new ArrayList<Eleve>();

            // Exploitation du résultat
            while (resultSet.next()) {
                Eleve e = new Eleve();
                e.setMatricule(resultSet.getInt("matricule"));
                e.setDate_inscription(resultSet.getDate("date_inscription"));
                e.setDate_naissance(resultSet.getDate("date_naissance"));
                e.setEtablissement_precedent(resultSet.getString("etablissement_precedent"));
                e.setClasse(classeDAO.find(resultSet.getInt("id_classe")));
                e.setCoord(coordonneesDAO.find(resultSet.getInt("id_coord")));
                e.setSante(carnetSanteDAO.find(resultSet.getInt("id_sante")));
                e.setSexe(resultSet.getInt("sexe"));
                e.setPrenom(resultSet.getString("prenom"));
                e.setNom(resultSet.getString("nom"));
                e.setVille_naissance(resultSet.getString("ville_naissance"));
                e.setPays_naissance(resultSet.getString("pays_naissance"));
                eleves.add(e);
            }

            return eleves;

        } catch (SQLException e) {
            System.err.println("Erreur SQL.");
        }

        return null;
    }
}
