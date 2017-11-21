package Login;

import javax.swing.*;

public class LoginView extends JPanel{
    private JFrame frame;
    private JPanel id;
    private JPanel password;

    public LoginView(){

        this.frame = new JFrame("Login");
        frame.setSize (300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        frame.setVisible(true);
    }
}
