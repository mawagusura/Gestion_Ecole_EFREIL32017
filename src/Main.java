import Modele.JavaBean.Utilisateur;
import Modele.Services.PrivilegeService;
import Modele.Services.UtilisateurService;

public class Main {

    public static void main(String[] args){
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

    }

}
