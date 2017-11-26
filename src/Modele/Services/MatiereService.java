package Modele.Services;

import Modele.DAO.MatiereDAO;
import Modele.DBConnector;
import Modele.JavaBean.Classe;
import Modele.JavaBean.Eleve;
import Modele.JavaBean.Matiere;

import java.util.ArrayList;

public class MatiereService {
    private MatiereDAO dao;

    public MatiereService() {
        this.dao = new MatiereDAO(DBConnector.getInstance());
    }

    public Matiere getMatiere(int id) {
        return dao.find(id);
    }

    public ArrayList<Matiere> getMatieres(Eleve e) {
        return dao.findByEleve(e.getMatricule());
    }

    public ArrayList<Matiere> getAllMatieres() {
        return dao.findAll();
    }

    public ArrayList<Matiere> getMatieres(Classe c) {
        if(c==null){
            return getAllMatieres();
        }
        return dao.findByClasse(c.getId_classe());
    }
}