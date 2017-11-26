package View;

import Modele.JavaBean.Eleve;

import javax.swing.*;

public class SecondaryFrame extends JFrame {

    public SecondaryFrame(int privilège, Eleve eleve){
        this.setTitle(eleve.getNom()+ " " + eleve.getPrenom());
        this.setVisible(true);
    }


}
