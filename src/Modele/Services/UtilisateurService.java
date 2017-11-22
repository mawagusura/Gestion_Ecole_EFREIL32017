package Modele.Services;

import Modele.DAO.UtilisateurDAO;
import Modele.DBConnector;
import Modele.Javabean.Utilisateur;

public class UtilisateurService {

    private UtilisateurDAO dao;

    public UtilisateurService() {
        this.dao = new UtilisateurDAO(DBConnector.getInstance());
    }

    public Utilisateur getUtilisateur(int id) {
        return dao.find(id);
    }

    public Utilisateur getUtilisateur(String mail) {
        return dao.find(mail);
    }

    public boolean verifyPassword(Utilisateur user, String password) {
        return user.getHash_mdp().equals(password);
    }

}
