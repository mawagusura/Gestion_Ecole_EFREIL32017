import Modele.Javabean.Utilisateur;
import Modele.Services.UtilisateurService;

public class Main {

    public static void main(String[] args){
        // Login
        String mail = "michel.dumas@gmail.com";
        String mdp = "1234";

        // Initialisation du service
        UtilisateurService userService = new UtilisateurService();

        // Récupération de l'user
        Utilisateur u = userService.getUtilisateur(mail);

        // Vérification du mot de passe
        if (userService.verifyPassword(userService.getUtilisateur(mail), mdp)) {
            System.out.println("Mot de passe correct.");
        } else {
            System.out.println("Mot de passe incorrect.");
        }

    }

}
