package Modele.Services;

import Modele.DAO.EleveDAO;
import Modele.DBConnector;
import Modele.JavaBean.Classe;
import Modele.JavaBean.Eleve;
import Modele.JavaBean.Matiere;

import java.util.ArrayList;

public class EleveService {

    private EleveDAO dao;

    public EleveService() {
        this.dao = new EleveDAO(DBConnector.getInstance());
    }

    public Eleve getEleve(int id) {
        return dao.find(id);
    }

    public ArrayList<Eleve> getAllEleves() { return dao.findAll(); }

    public ArrayList<Eleve> getEleves(Matiere m) {
        return dao.findByMatiere(m.getId_matiere());
    }

    public ArrayList<Eleve> getEleves(Classe c) {
        return dao.findByClasse(c.getId_classe());
    }


    public ArrayList<Eleve> getEleves(Classe c, Matiere m) {
        if(c == null && m==null){
            return dao.findAll();
        }
        else if(c==null && m!=null){
            return this.getEleves(m);
        }
        else if(c!=null && m==null){
            return this.getEleves(c);
        }
        return dao.find(c.getId_classe(), m.getId_matiere());
    }
}
