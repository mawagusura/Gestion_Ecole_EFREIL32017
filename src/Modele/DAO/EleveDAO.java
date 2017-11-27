package Modele.DAO;

import Modele.JavaBean.Eleve;
import Modele.JavaBean.Matiere;

import java.sql.*;
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
        try {
            // Préparation du statement
            Statement stmnt = connect.createStatement();
            String query = "DELETE FROM Eleve WHERE matricule = " + obj.getMatricule();

            // Exécution
            stmnt.executeUpdate(query);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Eleve obj){
        try {
            // Préparation du statement
            String query = "update Eleve set " +
                    "pays_naissance = ?," +
                    "sexe = ?," +
                    "date_inscription = ?," +
                    "etablissement_precedent = ?," +
                    "date_naissance = ?," +
                    "nom = ?," +
                    "prenom = ?," +
                    "id_classe = ?," +
                    "id_coord = ?," +
                    "id_sante = ?," +
                    "ville_naissance = ?" +
                    "where matricule = " + obj.getMatricule() ;

            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setString(1, obj.getPays_naissance());
            preparedStmt.setInt(2, obj.getSexe());
            preparedStmt.setDate(3, obj.getDate_inscription());
            preparedStmt.setString(4, obj.getEtablissement_precedent());
            preparedStmt.setDate(5, obj.getDate_naissance());
            preparedStmt.setString(6, obj.getNom());
            preparedStmt.setString(7, obj.getPrenom());
            preparedStmt.setInt(8, obj.getClasse().getId_classe());
            preparedStmt.setInt(9, obj.getCoord().getId_coord());
            preparedStmt.setInt(10, obj.getSante().getId_sante());
            preparedStmt.setString(11, obj.getVille_naissance());

            // Exécution
            preparedStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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
            e.printStackTrace();
            System.err.println("Erreur SQL.");
        }

        return null;
    }

    public Eleve find(String nom, String prenom) {
        try {

            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery(
                    "SELECT * FROM Eleve WHERE nom = \"" + nom + "\" AND prenom = \"" + prenom + "\"");

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
            e.printStackTrace();
            System.err.println("Erreur SQL.");
        }

        return null;
    }

    @Override
    public ArrayList<Eleve> findAll() {
        try {

            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery(
                    "SELECT * FROM Eleve"
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
            e.printStackTrace();
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
                            "SELECT matricule FROM Note WHERE id_matiere = "+ id_matiere +")"
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
            e.printStackTrace();
            System.err.println("Erreur SQL.");
        }

        return null;
    }

    public ArrayList<Eleve> findByClasse(int id_classe) {
        try {

            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery(
                    "SELECT * FROM Eleve WHERE matricule IN (" +
                            "SELECT matricule FROM Note WHERE id_classe = "+ id_classe +")"
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
            e.printStackTrace();
            System.err.println("Erreur SQL.");
        }

        return null;
    }

    public ArrayList<Eleve> find(int id_classe, int id_matiere) {
        try {

            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery(
                    "SELECT * FROM Eleve WHERE matricule IN (" +
                            "SELECT matricule FROM Note WHERE id_matiere = "+ id_matiere +") " +
                            "AND id_classe = " + id_classe);

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
            e.printStackTrace();
            System.err.println("Erreur SQL.");
        }

        return null;
    }
}
