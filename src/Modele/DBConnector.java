package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {

    // URL de connexion
    private String url = "jdbc:mysql://h0tmilk.fr:3306/gestion_ecole";

    // Nom USER
    private String user = "efrei-remote";

    // Mot de passe utilisateur
    private String passwd = "3fr3!";

    // Objet connexion
    private static Connection connect;

    //Constructeur privé
    private DBConnector(){
        try {
            connect = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connecté à la base de données.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur de connexion à la base de données.");
        }
    }

    // Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
    public static Connection getInstance() {
        if (connect == null) {
            new DBConnector();
        }
        return connect;
    }

    public void close(){
        try {
            this.connect.close();
            System.out.println("Déconnecté.");
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Impossible de se déconnecter de la base de données.");
        }
    }

}
