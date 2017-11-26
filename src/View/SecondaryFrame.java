package View;

import Controller.Controller;
import Modele.JavaBean.Classe;
import Modele.JavaBean.Eleve;
import Modele.JavaBean.Matiere;
import Modele.ViewModel.AcaModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class SecondaryFrame extends JFrame {

    private final Eleve eleve;
    private final int privilege;
    private final Controller controller;
    private  JTable tableau;
    private final String[] noms ={"Matiere", "Moyenne", "Coefficient"};

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
        this.tableau = new JTable();
        ArrayList<Matiere> matieres = this.controller.getMatiereService().getMatieres(this.eleve);
        Object[][] data = new Object[matieres.size()][3];

        for(int i=0;i<matieres.size();i++){
            Matiere e = matieres.get(i);
            data[i][0] = e.getNom_matiere();
            data[i][1] = this.controller.getNoteService().getNote(this.eleve,e);
            data[i][2] = this.controller.getNoteService().getNote(this.eleve,e).getCoefficient();
        }

        this.tableau.setModel(new AcaModel(data,this.noms));

        this.tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane grille = new JScrollPane(tableau);


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
            b1.add(p1);

            JButton p2 = new JButton("Ajouter une matière à l'élève");
            p2.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleAjoutMatiere();
                }
            });
            b1.add(p2);
            JButton valider = new JButton("Valider les modifications");
            b1.add(new JLabel("Moyenne générale : "+this.controller.getNoteService().getMoyenne(this.eleve)));
            b1.add(valider);
        }
        else{
            JLabel classe = new JLabel(this.eleve.getClasse().getNom());
            p1.add(classe);
            b1.add(p1);
            b1.add(new JLabel("Moyenne générale : "+this.controller.getNoteService().getMoyenne(this.eleve)));
        }

        mainPanel.add(grille);
        mainPanel.add(b1);
        this.getContentPane().add(mainPanel);

        this.setTitle(eleve.getNom()+ " " + eleve.getPrenom());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(00,250);
        this.setVisible(true);
    }

    public void handleAjoutMatiere(){
        this.controller.handleAjoutMatiere(this);
    }

}
