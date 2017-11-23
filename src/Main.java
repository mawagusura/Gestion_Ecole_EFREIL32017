import Modele.JavaBean.Eleve;
import Modele.JavaBean.Utilisateur;
import Modele.Services.CoordonneesService;
import Modele.Services.EleveService;
import Modele.Services.PrivilegeService;
import Modele.Services.UtilisateurService;

public class Main {

    public static void main(String[] args){

        // Exemple login -------------------------------
        System.out.println("\n---- Login 1 -------");
        // Login
        String mail = "michel.dumas@gmail.com";
        String mdp = "1234";
        System.out.println(mail + " / " + mdp);

        // Initialisation des services
        UtilisateurService userService = new UtilisateurService();
        PrivilegeService privilegeService = new PrivilegeService();

        // Récupération de l'user
        Utilisateur u = userService.getUtilisateur(mail);

        // Vérification du mot de passe
        if (userService.verifyPassword(userService.getUtilisateur(mail), mdp)) {
            System.out.println("Mot de passe correct.");
            System.out.println("Privilège acquis : "
                    + privilegeService.getPrivilege(u.getId_privilege()).getLibelle());
        } else {
            System.out.println("Mot de passe incorrect.");
        }

        // Login
        System.out.println("\n---- Login 2 -------");
        mail = "adrien.lafaix@gmail.com";
        mdp = "1234";
        System.out.println(mail + " / " + mdp);

        // Récupération de l'user
        u = userService.getUtilisateur(mail);

        // Vérification du mot de passe
        if (userService.verifyPassword(userService.getUtilisateur(mail), mdp)) {
            System.out.println("Mot de passe correct.");
            System.out.println("Privilège acquis : "
                    + privilegeService.getPrivilege(u.getId_privilege()).getLibelle());
        } else {
            System.out.println("Mot de passe incorrect.");
        }

        // Exemple récupération d'un élève ----------------------------------
        System.out.println("\n-----------------------------");

        // Chargement des services
        EleveService es = new EleveService();
        CoordonneesService cs = new CoordonneesService();

        // Récupération de l'élève 1
        Eleve e = es.getEleve(15);

        try {
            System.out.println("\nElève n°15 :");
            System.out.println("Nom : "+ e.getNom());
            System.out.println("Prenom : "+ e.getPrenom());
            System.out.println("Téléphone fixe : " + cs.getCoordonnees(e.getId_coord()).getTel_fixe());
        } catch (NullPointerException ex) {
            System.err.println("Aucun élève d'a pour id 15");
        }
    }

}
