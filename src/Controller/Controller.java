package Controller;

import Modele.Database;
import Modele.Javabean.Utilisateur;
import View.LoginView;
import View.MainFrame;

import java.awt.event.WindowEvent;

public class Controller {

    public static void connect(LoginView loginView, String id, String mdp){
        if(!id.isEmpty() && !mdp.isEmpty()){
            Utilisateur user = Database.getUtilisateur(id);


            loginView.dispose();
            MainFrame appli = new MainFrame();
        }
        else{
            loginView.throwPopup("Veuillez entrer identifiant et mot de passe afin de vous connecter à SchoolAdmin");
        }
    }

}
