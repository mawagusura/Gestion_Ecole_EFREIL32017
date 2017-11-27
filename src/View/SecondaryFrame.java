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

public class SecondaryFrame extends AbstractPopup {


    private  JTable tableau;
    private final String[] noms ={"Matiere", "Moyenne", "Coefficient"};
    private JComboBox<Classe> classe;

    public SecondaryFrame(int privilege, Eleve eleve, Controller controller, MainFrame mainFrame){

        super(privilege,eleve,controller,mainFrame);

        JPanel mainPanel = new JPanel();
        GridLayout gl = new GridLayout();
        gl.setColumns(2);
        gl.setRows(1);
        mainPanel.setLayout(gl);

        // Tableau
        this.tableau = new JTable();
        drawTableau();

        this.tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane grille = new JScrollPane(tableau);


        // Paneau droite
        Box b1 = Box.createVerticalBox();
        JPanel p1 = new JPanel();

        //En fonction du privilège
        p1.add(new JLabel("Classe : "));
        if(privilege==1){
            this.classe = new JComboBox<>();
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
            JButton p3 = new JButton("Supprimer une matière");
            p3.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleSupprMatiere();
                }
            });
            b1.add(p3);
            JButton valider = new JButton("Valider les modifications");
            valider.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleValidation();
                }
            });
            b1.add(new JLabel("Moyenne générale : "+this.controller.getNoteService().getMoyenne(this.eleve)));
            b1.add(valider);
        }
        else{
            JLabel classe2 = new JLabel(this.eleve.getClasse().getNom());
            p1.add(classe2);
            b1.add(p1);
            b1.add(new JLabel("Moyenne générale : "+this.controller.getNoteService().getMoyenne(this.eleve)));
        }

        mainPanel.add(grille);
        mainPanel.add(b1);
        this.getContentPane().add(mainPanel);

        this.setVisible(true);
    }

    public void drawTableau(){
        ArrayList<Matiere> matieres = this.controller.getMatiereService().getMatieres(this.eleve);
        Object[][] data = new Object[matieres.size()][3];

        for(int i=0;i<matieres.size();i++){
            Matiere e = matieres.get(i);
            data[i][0] = e;
            data[i][1] = this.controller.getNoteService().getNote(this.eleve,e).getNote();
            data[i][2] = this.controller.getNoteService().getNote(this.eleve,e).getCoefficient();
        }

        this.tableau.setModel(new AcaModel(data,this.noms, true));
    }

    private void handleAjoutMatiere(){
        this.controller.handleAjoutMatiere(this);
    }

    private void handleValidation(){
        this.controller.handleValidation(this, false);
    }

    private void handleSupprMatiere(){
        this.controller.handleSupprMatiere(this);
    }

    /**
     * getters and setters
     */
    public JTable getTableau() {
        return tableau;
    }

    public String[] getNoms() {
        return noms;
    }

    public JComboBox<Classe> getClasse() {
        return classe;
    }
}
