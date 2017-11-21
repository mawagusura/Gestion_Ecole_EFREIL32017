package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


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

        this.mdpTF.setPreferredSize(new Dimension(150,30));
        this.loginTF.setPreferredSize(new Dimension(150,30));

        this.setVisible(true);
    }

    private JPanel draw(){

        JPanel container = new JPanel();

        container.setLayout(new BorderLayout());
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new GridLayout(2,2,5,5));

        wrapper.add(new JLabel("Identifiant : "));
        wrapper.add(this.loginTF);

        wrapper.add(new JLabel("Mot de passe : "));
        wrapper.add(this.mdpTF);

        JPanel content = new JPanel();
        content.add(wrapper);
        content.add(this.connectBT);

        JPanel titre = new JPanel();
        titre.setBackground(Color.DARK_GRAY);
        JLabel label = new JLabel(("SchoolAdmin"));
        label.setForeground(Color.RED);
        label.setFont(new Font("Arial",Font.BOLD,14));
        titre.add(label);

        container.add(titre,BorderLayout.NORTH);
        container.add(content, BorderLayout.CENTER);

        return container;
    }

    @Override
    public void actionPerformed(ActionEvent e){
            Controller.connect(this,
                    this.loginTF.getText(),
                    this.mdpTF.getText());
    }

    public void throwPopup (String s){
        JOptionPane jop = new JOptionPane();
        jop.showMessageDialog(this, s, "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
    }

}
