package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;



public class LoginView extends JFrame{
    JTextField loginTF = new JTextField("michel.dumas@gmail.com");
    JTextField mdpTF = new JTextField("1234");
    JButton connectBT = new JButton("Connexion");

    public LoginView(){
        this.setTitle("Gestion Ecole");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(this.draw());
        //this.connectBT.addActionListener(this);

        this.mdpTF.setPreferredSize(new Dimension(150,30));
        this.loginTF.setPreferredSize(new Dimension(150,30));

        this.connectBT.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");

        Action action = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                test();
            }
        };
        this.connectBT.getActionMap().put("Enter", action);
        this.connectBT.addActionListener(action);

        this.setVisible(true);
    }

    private void test(){
        Controller.connect(this,
                this.loginTF.getText(),
                this.mdpTF.getText());    }

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

    public void throwPopup (String s){
        JOptionPane jop = new JOptionPane();
        jop.showMessageDialog(this, s, "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
    }

}
