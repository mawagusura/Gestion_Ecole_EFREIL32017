package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class LoginView extends JFrame implements ActionListener{
    JTextField loginTF = new JTextField();
    JTextField mdpTF = new JTextField();
    JButton connectBT = new JButton("Connexion");

    public LoginView(){
        this.setTitle("Gestion Ecole");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(this.draw());
        this.connectBT.addActionListener(this);
        this.setVisible(true);
    }

    private JPanel draw(){

        JPanel container = new JPanel();

        this.mdpTF.setPreferredSize(new Dimension(150,30));
        this.loginTF.setPreferredSize(new Dimension(150,30));


        container.setLayout(new BorderLayout());

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new GridLayout(2,2,5,5));

        wrapper.add(new JLabel("Identifiant : "));
        wrapper.add(loginTF);

        wrapper.add(new JLabel("Mot de passe : "));
        wrapper.add(mdpTF);

        JPanel content = new JPanel();
        content.add(wrapper);
        content.add(connectBT);

        Box titre = Box.createHorizontalBox();
        titre.setForeground(Color.DARK_GRAY);
        titre.add(new JLabel("SchoolAdmin"));
        titre.setBackground(Color.RED);

        container.add(titre,BorderLayout.NORTH);
        container.add(content, BorderLayout.CENTER);

        return container;
    }

    public void actionPerformed(ActionEvent e){
        Controller.connect(this, this.loginTF.getText(), this.mdpTF.getText());
    }

    public void throwPopup (String s){
        JOptionPane jop3 = new JOptionPane();
        jop3.showMessageDialog(this, s, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

}
