import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {

    private static DBConnector Instance = null;

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
            Connection conn = DriverManager.getConnection("jdbc:mysql://h0tmilk.fr:3306/gestion_ecole", "efrei", "3fr3!db");
            System.out.println("Connecté");
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Impossible de se connecter à la base de données");
        }
    }

}
