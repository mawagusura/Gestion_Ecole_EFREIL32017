package Modele.DAO;

import Modele.JavaBean.Eleve;

import java.sql.Connection;

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
    public Eleve find(int id) {
        return null;
    }
}
