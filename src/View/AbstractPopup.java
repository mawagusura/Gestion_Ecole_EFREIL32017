package View;

import Controller.Controller;
import Modele.JavaBean.Eleve;

import javax.swing.*;

public abstract class AbstractPopup extends JFrame {

    protected final MainFrame mainFrame;
    protected final Eleve eleve;
    protected final int privilege;
    protected final Controller controller;

    public AbstractPopup(int privilege, Eleve eleve, Controller controller, MainFrame mainFrame){
        this.controller=controller;
        this.eleve=eleve;
        this.privilege=privilege;
        this.mainFrame=mainFrame;

        this.setTitle(eleve.getNom()+ " " + eleve.getPrenom());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(500,250);
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public int getPrivilege() {
        return privilege;
    }

}
