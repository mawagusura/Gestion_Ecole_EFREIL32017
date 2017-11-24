package Modele.DAO;

import Modele.JavaBean.Classe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClasseDAO extends DAO<Classe> {

    public ClasseDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Classe obj) {
        return false;
    }

    @Override
    public boolean delete(Classe obj) {
        return false;
    }

    @Override
    public boolean update(Classe obj) {
        return false;
    }

    @Override
    public Classe find(int id) {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Classe WHERE id_classe = " + id);

            // Exploitation du résultat
            while (resultSet.next()) {
                Classe c = new Classe();
                c.setId_classe(resultSet.getInt("id_classe"));
                c.setId_niveau(resultSet.getInt("id_niveau"));
                c.setNom(resultSet.getString("nom"));
                return c;
            }
        } catch(SQLException e) {
            System.err.println("Erreur SQL");
        }

        // Si on trouve rien, on renvoie null
        return null;
    }
}
