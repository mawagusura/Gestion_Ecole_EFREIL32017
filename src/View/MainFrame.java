package View;

import Controller.Controller;

import javax.swing.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainFrame extends JFrame {

    private JTabbedPane onglet = new JTabbedPane(JTabbedPane.LEFT);
    private Controller controller;

    public MainFrame(Controller controller){
        this.setTitle("SchoolAdmin");
        //this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handleClosing();
            }
        });
        this.setSize(1300, 600);
        this.controller = controller;

        onglet.addTab("Gestion académique",new JPanel());
        onglet.addTab("Gestion administrative",new JPanel());

        this.getContentPane().add(onglet);

        this.setVisible(true);

    }

    public void handleClosing() {
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Etes vous sur de vouloir quitter ? ?", "Quitter ?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(option == JOptionPane.OK_OPTION){
            this.dispose();
        }
    }

}
