package Modele.Services;

import Modele.DAO.EleveDAO;
import Modele.DBConnector;
import Modele.JavaBean.Eleve;

public class EleveService {

    private EleveDAO dao;

    public EleveService() {
        this.dao = new EleveDAO(DBConnector.getInstance());
    }

    public Eleve getEleve(int id) {
        return dao.find(id);
    }

}
