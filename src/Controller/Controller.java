package Controller;

import Modele.JavaBean.*;
import Modele.Services.*;
import View.LoginView;
import View.MainFrame;
import Modele.ViewModel.*;
import View.SecondaryFrame;

import javax.swing.*;
import java.util.ArrayList;

import static java.lang.System.exit;

public class Controller {

    /**
     * Services
     */
    private final EleveService eleveService;
    private final CoordonneesService coordonneesService;
    private final CarnetSanteService carnetSanteService;
    private final ClasseService classeService;
    private final ResponsableService responsableService;
    private final MatiereService matiereService;
    private final NoteService noteService;
    private final UtilisateurService utilisateurService;
    private final PrivilegeService privilegeService;

    /**
     * Constructeur
     */
    public Controller(){
        this.eleveService = new EleveService();
        this.coordonneesService = new CoordonneesService();
        this.carnetSanteService = new CarnetSanteService();
        this.classeService = new ClasseService();
        this.responsableService = new ResponsableService();
        this.matiereService = new MatiereService();
        this.noteService = new NoteService();
        this.utilisateurService = new UtilisateurService();
        this.privilegeService = new PrivilegeService();
    }

    /**
     * Méthode qui vérifie les informations de connexion entrées par l'utilisateur,
     *  et qui lance l'application principale si ces dernièressont correctes.
     * @param loginView
     * @param id
     * @param mdp
     */
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

    /**
     * Méthode qui gère l'event de fermeture de la fenetre.
     * Demande une confirmation à l'utilisateur
     */
    public void handleClosing(MainFrame main) {
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Etes vous sur de vouloir quitter ?", "Quitter ?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(option == JOptionPane.OK_OPTION){
            main.dispose();
        }
        exit(0);
    }

    /**
     * Méthode gérant le clic sur le bouton Modifier / consulter.
     * Lance une nouvelle fenêtre si une ligne du tableau est sélectionnée.
     */
    public void handleClickUser(MainFrame main, int privilege){
        if(main.getTableau().getSelectedRow()!= -1) {
            String prenom = (String) main.getTableau().getModel().getValueAt(main.getTableau().getSelectedRow(),0);
            String nom = (String) main.getTableau().getModel().getValueAt(main.getTableau().getSelectedRow(),1);
            Eleve e = this.eleveService.getEleve(nom,prenom);

            SecondaryFrame sec = new SecondaryFrame(privilege,e,this);
        }
        else{
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(main, "Veuillez sélectionner un élève dans la liste.","Sélectionnez un élève", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Méthode qui gère le changement d'état des comboBox.
     * Met à jour le tableau des éleves
     */
    public void handleComboChange(MainFrame main){
        Classe currC =(Classe) main.getComboC().getSelectedItem();
        Matiere currM = (Matiere) main.getComboM().getSelectedItem();

        ArrayList<Eleve> eleves = this.eleveService.getEleves(currC,currM);

        Object[][] data = new Object[eleves.size()][4];

        for(int i=0;i<eleves.size();i++){
            Eleve e = eleves.get(i);
            data[i][0] = e.getPrenom();
            data[i][1] = e.getNom();
            data[i][2] = e.getSexe() == 1 ? "Homme" : "Femme";
            data[i][3] = e.getClasse();
        }

        main.getTableau().setModel(new AcaModel(data,main.getNoms()));
    }

    /**
     * Méthode qui gère l'ajout d'une matière à un élève.
     * @return
     */
    public void handleAjoutMatiere(SecondaryFrame s){
        Object[] possibilities = {"ham", "spam", "yam"};
        Matiere m = (Matiere) JOptionPane.showInputDialog(
                s,
                "Veuillez sélectionner une matière à ajouter à l'élève :\n",
                "Nouvelle Matière",
                JOptionPane.PLAIN_MESSAGE,
                null,
                this.matiereService.getAllMatieres().toArray(),
                this.matiereService.getAllMatieres().get(0)
                );

        //If a string was returned, say so.
        if ((m != null)) {
            Note n = new Note();
            n.setEleve(s.getEleve());
            n.setMatiere(m);
            this.noteService.persist_new(n);
            s.drawTableau();
        }
    }

    /**
     * Gère la modification des données d'un élève
     * @return
     */
    public void handleValidation(SecondaryFrame s) {


        //loop tableau
        for(int i=1;i<this.matiereService.getMatieres(s.getEleve()).size();i++){
            Note temp = this.noteService.getNote(
                    s.getEleve(),
                    (Matiere) s.getTableau().getModel().getValueAt(i,0));
            temp.setNote(Float.parseFloat(String.valueOf(s.getTableau().getValueAt(i,1))));
            temp.setCoefficient((Float) s.getTableau().getModel().getValueAt(i,2));
            this.noteService.persist(temp);
        }

        s.getEleve().setClasse((Classe) s.getClasse().getSelectedItem());
        this.eleveService.persist(s.getEleve());


        s.dispose();

    }



    public EleveService getEleveService() {
        return eleveService;
    }

    public CoordonneesService getCoordonneesService() {
        return coordonneesService;
    }

    public CarnetSanteService getCarnetSanteService() {
        return carnetSanteService;
    }

    public ClasseService getClasseService() {
        return classeService;
    }

    public ResponsableService getResponsableService() {
        return responsableService;
    }

    public MatiereService getMatiereService() {
        return matiereService;
    }

    public NoteService getNoteService() {
        return noteService;
    }

    public UtilisateurService getUtilisateurService() {
        return utilisateurService;
    }

    public PrivilegeService getPrivilegeService() {
        return privilegeService;
    }
}
