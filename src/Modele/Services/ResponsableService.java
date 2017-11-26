package Modele.Services;

import Modele.DAO.ResponsableDAO;
import Modele.DBConnector;
import Modele.JavaBean.Eleve;
import Modele.JavaBean.Responsable;

import java.util.ArrayList;

public class ResponsableService {

    private ResponsableDAO dao;

    public ResponsableService() {
        this.dao = new ResponsableDAO(DBConnector.getInstance());
    }

    public Responsable getResponsable(int id) {
        return dao.find(id);
    }

    public ArrayList<Responsable> getResponsables(Eleve e) {
        return dao.findByEleve(e.getMatricule());
    }

    public ArrayList<Responsable> getAllResponsables() { return dao.findAll(); }

    public boolean persist(Responsable r) {
        return dao.update(r);
    }

    public boolean persist_delete(Responsable r) {
        return dao.delete(r);
    }
}
