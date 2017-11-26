package Modele.Services;

import Modele.DAO.CoordonneesDAO;
import Modele.DBConnector;
import Modele.JavaBean.Coordonnees;

public class CoordonneesService {

    private CoordonneesDAO dao;

    public CoordonneesService() {
        this.dao = new CoordonneesDAO(DBConnector.getInstance());
    }

    public Coordonnees getCoordonnees(int id) {
        return dao.find(id);
    }

    public boolean persist(Coordonnees c) {
        return dao.update(c);
    }

    public boolean persist_delete(Coordonnees c) {
        return dao.delete(c);
    }
}
