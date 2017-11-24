package Modele.JavaBean;

import Modele.DAO.MatiereDAO;
import Modele.DBConnector;

public class MatiereService {
    private MatiereDAO dao;

    public MatiereService() {
        this.dao = new MatiereDAO(DBConnector.getInstance());
    }

    public Matiere getMatiere(int id) {
        return dao.find(id);
    }
}
