package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {

    private static DBConnector Instance = null;
    private static Connection conn;

    /**
     *
     * @return
     */
    public static DBConnector connect(){
        if(Instance == null) {
            Instance = new DBConnector();
        }
        return Instance;
    }

    private DBConnector() {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://h0tmilk.fr:3306/gestion_ecole", "efrei-remote", "3fr3!");
            System.out.println("Connecté");
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Impossible de se connecter à la base de données");
        }
    }

    public void close(){
        try {
            this.conn.close();
            System.out.println("Déconnecté");
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Impossible de se déconnecter de la base de données");
        }
    }

}
