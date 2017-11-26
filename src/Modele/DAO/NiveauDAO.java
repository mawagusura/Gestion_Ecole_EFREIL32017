package Modele.DAO;

import Modele.JavaBean.Niveau_classe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NiveauDAO extends DAO<Niveau_classe>{
    public NiveauDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Niveau_classe obj) {
        return false;
    }

    @Override
    public boolean delete(Niveau_classe obj) {
        return false;
    }

    @Override
    public boolean update(Niveau_classe obj) {
        return false;
    }

    @Override
    public Niveau_classe find(int id) {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Niveau_classe WHERE id_niveau = " + id);

            // Exploitation du résultat
            while (resultSet.next()) {
                Niveau_classe n = new Niveau_classe();
                n.setId_niveau(resultSet.getInt("id_niveau"));
                n.setNom(resultSet.getString("nom"));
                return n;
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur SQL");
        }

        // Si on trouve rien, on renvoie null
        return null;
    }

    @Override
    public ArrayList<Niveau_classe> findAll() {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Niveau_classe");

            // ArrayList des niveaux
            ArrayList<Niveau_classe> niveaux = new ArrayList<Niveau_classe>();

            // Exploitation du résultat
            while (resultSet.next()) {
                Niveau_classe n = new Niveau_classe();
                n.setId_niveau(resultSet.getInt("id_niveau"));
                n.setNom(resultSet.getString("nom"));
                niveaux.add(n);
            }
            return niveaux;
        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur SQL");
        }

        // Si on trouve rien, on renvoie null
        return null;
    }
}
