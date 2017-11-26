import Controller.Controller;
import View.LoginView;

public class Main {

    public static void main(String[] args){
/*
        // Chargement des services
        EleveService eleveService = new EleveService();
        CoordonneesService coordinneesService = new CoordonneesService();
        CarnetSanteService carnetSanteService = new CarnetSanteService();
        ClasseService classeService = new ClasseService();
        ResponsableService responsableService = new ResponsableService();
        MatiereService matiereService = new MatiereService();
        NoteService noteService = new NoteService();
        UtilisateurService utilisateurService = new UtilisateurService();
        PrivilegeService privilegeService = new PrivilegeService();

        // ---------------------------------------------
        // Exemple login -------------------------------
        // ---------------------------------------------

        System.out.println("\n---- Login 1 -------");

        // Informations de login
        String mail = "michel.dumas@gmail.com";
        String mdp = "1234";
        System.out.println(mail + " / " + mdp);

        // Récupération de l'user
        Utilisateur u = utilisateurService.getUtilisateur(mail);

        // Vérification du mot de passe
        if (utilisateurService.verifyPassword(utilisateurService.getUtilisateur(mail), mdp)) {
            System.out.println("Mot de passe correct.");
            System.out.println("Privilège acquis : "
                    + privilegeService.getPrivilege(u.getId_privilege()).getLibelle());
        } else {
            System.out.println("Mot de passe incorrect.");
        }

        // ------------------------------------------------------------------
        // Exemple récupération d'un élève ----------------------------------
        // ------------------------------------------------------------------

        System.out.println("\n-----------------------------");

        // Id de l'élève
        int id = 15;

        // Récupération de l'élève 1
        Eleve e = eleveService.getEleve(id);

        try {
            System.out.println("\nElève n°15 :");
            System.out.println("Nom : "+ e.getNom());
            System.out.println("Prenom : "+ e.getPrenom());
            System.out.println("Téléphone fixe : " + coordinneesService.getCoordonnees(e.getId_coord()).getTel_fixe());
            System.out.println("Médecin traitant : "+ carnetSanteService.getCarnetSante(e.getId_sante()).getMedecin_traitement());
            System.out.println("Classe : " + classeService.getClasse(e.getId_classe()).getNom());
            System.out.println("Responsables : ");
            for (Responsable r:responsableService.getResponsables(e)) {
                System.out.println(" - " + r.getPrenom() + " " + r.getNom().toUpperCase());
            }
            System.out.println("");
        } catch (NullPointerException ex) {
            System.err.println("Aucun élève d'a pour id "+id);
        }

        // -------------------------------------------------------------------------------
        // Exemple récupération d'un élève et des notes ----------------------------------
        // -------------------------------------------------------------------------------

        System.out.println("\nNotes de " + e.getPrenom() + " : ");

        // Récupération des notes
        String nom_matiere;
        for (Note note:noteService.getNotes(e)) {
            nom_matiere = matiereService.getMatiere(note.getId_matiere()).getNom_matiere();
            System.out.println(" " + nom_matiere + " : " + note.getNote() + " coef. " + note.getCoefficient());
        }
*/
        Controller  controller = new Controller();
        LoginView loginView = new LoginView(controller);

    }

}
