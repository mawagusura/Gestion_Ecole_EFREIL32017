package Modele.Services;

import Modele.DAO.ClasseDAO;
import Modele.DBConnector;
import Modele.JavaBean.Classe;

import java.util.ArrayList;

public class ClasseService {
    private ClasseDAO dao;

    public ClasseService() {
        this.dao = new ClasseDAO(DBConnector.getInstance());
    }

    public Classe getClasse(int id) {
        return dao.find(id);
    }

    public ArrayList<Classe> getAllClasses() { return dao.findAll(); }
}
