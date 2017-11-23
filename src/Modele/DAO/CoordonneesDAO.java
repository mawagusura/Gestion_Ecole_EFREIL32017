package Modele.DAO;

import Modele.JavaBean.Coordonnees;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CoordonneesDAO extends DAO<Coordonnees> {

    public CoordonneesDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Coordonnees obj) {
        return false;
    }

    @Override
    public boolean delete(Coordonnees obj) {
        return false;
    }

    @Override
    public boolean update(Coordonnees obj) {
        return false;
    }

    @Override
    public Coordonnees find(int id) {
        try {
            // Préparation et exécution de la requête
            Statement stmnt;
            stmnt = connect.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM Coordonnees WHERE id_coord = " + id);

            // Exploitation du résultat
            while (resultSet.next()) {
                Coordonnees c = new Coordonnees();
                c.setId_coord(resultSet.getInt("id_coord"));
                c.setAdresse(resultSet.getString("adresse"));
                c.setMail(resultSet.getString("mail"));
                c.setTel_fixe(resultSet.getString("tel_fixe"));
                c.setTel_mobile(resultSet.getString("tel_mobile"));
                c.setVille(resultSet.getString("ville"));
                return c;
            }
        } catch(SQLException e) {
            System.err.println("Erreur SQL");
        }

        // Si on trouve rien, on renvoie null
        return null;
    }
}
