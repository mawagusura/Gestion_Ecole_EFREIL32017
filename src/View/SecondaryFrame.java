package View;

import Controller.Controller;
import Modele.JavaBean.Classe;
import Modele.JavaBean.Eleve;
import Modele.JavaBean.Matiere;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SecondaryFrame extends JFrame {

    private final Eleve eleve;
    private final int privilege;
    private final Controller controller;

    public SecondaryFrame(int privilege, Eleve eleve, Controller controller){

        this.eleve =eleve;
        this.privilege = privilege;
        this.controller = controller;

        JPanel mainPanel = new JPanel();
        GridLayout gl = new GridLayout();
        gl.setColumns(2);
        gl.setRows(1);
        mainPanel.setLayout(gl);
        // Tableau




        // Paneau droite
        Box b1 = Box.createVerticalBox();
        JPanel p1 = new JPanel();

        //En fonction du privilège
        p1.add(new JLabel("Classe : "));
        if(privilege==1){
            JComboBox<Classe> classe = new JComboBox<>();
            for( Classe c : this.controller.getClasseService().getAllClasses()){
                classe.addItem(c);
            }
            p1.add(classe);

            JButton p2 = new JButton("Ajouter une matière à l'élève");
            p2.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleAjoutMatiere();
                }
            });
            b1.add(p2);
        }
        else{
            JLabel classe = new JLabel(this.eleve.getClasse().getNom());
            p1.add(classe);
        }
        b1.add(p1);

        //ajout matière





        //b1.add(this.eleve.)

        mainPanel.add(b1);
        this.getContentPane().add(mainPanel);

        this.setTitle(eleve.getNom()+ " " + eleve.getPrenom());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,400);
        this.setVisible(true);
    }

    public void handleAjoutMatiere(){
        this.controller.handleAjoutMatiere(this);
    }

}
