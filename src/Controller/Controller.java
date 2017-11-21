package Controller;

import View.LoginView;

public class Controller {

    public static void connect(LoginView loginView, String id, String mdp){
        if(!id.isEmpty() && !mdp.isEmpty()){

        }
        else{
            loginView.throwPopup("Veuillez entrer identifiants et mot de passe afin de vous connecter à SchoolAdmin");
        }
    }

}
