package Controller;

import Modele.JavaBean.Utilisateur;
import Modele.Services.*;
import View.LoginView;
import View.MainFrame;

import javax.swing.*;

public class Controller {

    private final EleveService eleveService;
    private final CoordonneesService coordonneesService;
    private final CarnetSanteService carnetSanteService;
    private final ClasseService classeService;
    private final ResponsableService responsableService;
    //private final MatiereService matiereService;
    private final NoteService noteService;
    private final UtilisateurService utilisateurService;
    private final PrivilegeService privilegeService;

    public Controller(){
        this.eleveService = new EleveService();
        this.coordonneesService = new CoordonneesService();
        this.carnetSanteService = new CarnetSanteService();
        this.classeService = new ClasseService();
        this.responsableService = new ResponsableService();
        //this.matiereService = new MatiereService();
        this.noteService = new NoteService();
        this.utilisateurService = new UtilisateurService();
        this.privilegeService = new PrivilegeService();
    }

    public void connect(LoginView loginView, String id, String mdp){

        if(!id.isEmpty() && !mdp.isEmpty()){
            Utilisateur temp = this.utilisateurService.getUtilisateur(id);
            if(temp != null && this.utilisateurService.verifyPassword(temp,mdp)){
                loginView.throwPopup("Vous vous connectez en tant que "+temp.getPrivilege().getLibelle(),"Connexion",JOptionPane.INFORMATION_MESSAGE);
                loginView.dispose();
                MainFrame appli = new MainFrame(this,temp);
            }
            else{
                loginView.throwPopup("Erreur de connexion. Vérifiez vos identifiants et mots de passe.","Erreur Connexion",JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            loginView.throwPopup("Veuillez entrer un identifiant et un mot de passe pour pouvoir vous connecter.", "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
        }
    }

}
