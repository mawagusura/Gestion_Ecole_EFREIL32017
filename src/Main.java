import Modele.DBConnector;
import View.LoginView;

public class Main {

    public static void main(String[] args){
        DBConnector db=DBConnector.connect();
        db.close();
        LoginView log = new LoginView();
    }
}
