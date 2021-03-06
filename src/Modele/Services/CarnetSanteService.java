package Modele.Services;

import Modele.DAO.CarnetSanteDAO;
import Modele.DBConnector;
import Modele.JavaBean.Carnet_sante;

public class CarnetSanteService {
    private CarnetSanteDAO dao;

    public CarnetSanteService() {
        this.dao = new CarnetSanteDAO(DBConnector.getInstance());
    }

    public Carnet_sante getCarnetSante(int id) {
        return dao.find(id);
    }

    public boolean persist(Carnet_sante c) {
        return dao.update(c);
    }

    public boolean persist_delete(Carnet_sante c) {
        return dao.delete(c);
    }

}
