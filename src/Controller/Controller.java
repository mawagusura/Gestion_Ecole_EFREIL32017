package Controller;

import Modele.DAO.UtilisateurDAO;
import Modele.DBConnector;
import Modele.JavaBean.Utilisateur;
import View.LoginView;
import View.MainFrame;

public class Controller {

    public static void connect(LoginView loginView, String id, String mdp){
        if(!id.isEmpty() && !mdp.isEmpty()){
            UtilisateurDAO userDao = new UtilisateurDAO(DBConnector.getInstance());
            Utilisateur user = userDao.find(id);

            loginView.dispose();
            MainFrame appli = new MainFrame();
        }
        else{
            loginView.throwPopup("Veuillez entrer identifiant et mot de passe afin de vous connecter à SchoolAdmin");
        }
    }

}
