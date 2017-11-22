package Modele.Services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Modele.DAO.UtilisateurDAO;
import Modele.DBConnector;
import Modele.Javabean.Utilisateur;

public class UtilisateurService {

    private UtilisateurDAO dao;

    public UtilisateurService() {
        this.dao = new UtilisateurDAO(DBConnector.getInstance());
    }

    public Utilisateur getUtilisateur(int id) {
        return dao.find(id);
    }

    public Utilisateur getUtilisateur(String mail) {
        return dao.find(mail);
    }

    public boolean verifyPassword(Utilisateur user, String password) {
        return user.getHash_mdp().equals(hash_password(password));
    }

    private String hash_password(String password) {
        // Il s'agit d'un algorithme de hachage SHA256

        StringBuffer sb = new StringBuffer();
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());

            byte byteData[] = md.digest();

            //convert the byte to hex format method 1
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

        } catch(NoSuchAlgorithmException e) {
            System.err.println("Hash du mot de passe impossible.");
        }

        return sb.toString();
    }
}
