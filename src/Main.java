import Modele.*;
import Modele.Javabean.*;
import Modele.DAO.*;

public class Main {

    public static void main(String[] args){
        UtilisateurDAO utilisateurDao = new UtilisateurDAO(DBConnector.getInstance());
        Utilisateur exemple = utilisateurDao.find("michel.dumas@gmail.com");

        System.out.println("Utilisateur n°" + exemple.getId_utilisateur());
        System.out.println("Nom : " + exemple.getNom());
        System.out.println("Prénom : " + exemple.getPrenom());
        System.out.println("Mot de passe : " + exemple.getHash_mdp());
        System.out.println("Adresse mail : " + exemple.getMail());
        System.out.println("Privilèges : " + exemple.getPrivilege().getLibelle() + "(" + exemple.getPrivilege().getId_privilege() + ")");
    }
}
