package View;

import Controller.Controller;
import Modele.JavaBean.Classe;
import Modele.JavaBean.Eleve;
import Modele.JavaBean.Matiere;
import Modele.JavaBean.Utilisateur;
import Modele.Services.ClasseService;
import Modele.Services.EleveService;
import Modele.Services.MatiereService;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    /**
     * GUI related attributes
     */
    private JTabbedPane onglet = new JTabbedPane();
    private JTable tableau;
    private JComboBox<Classe> comboC;
    private JComboBox<Matiere> comboM;

    /**
     * Data Related attributes
     */
    private Controller controller;
    private Utilisateur utilisateur;
    private final String noms[] = {"Prénom","Nom","Sexe","Classe"};


    public MainFrame(Controller controller, Utilisateur user){

        this.utilisateur = user;

        this.setTitle("SchoolAdmin");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handleClosing();
            }
        });
        this.setSize(1300, 600);
        this.controller = controller;

        JPanel aca = new JPanel();
        JPanel admin = new JPanel();

        // Panel académique
        JPanel bl = new JPanel();
        bl.setLayout(new BorderLayout());
        JLabel titre = new JLabel("Liste des élèves");
        JLabel util = new JLabel(this.utilisateur.getNom()+" "+this.utilisateur.getPrenom());

        bl.add(titre,BorderLayout.WEST);
        bl.add(util,BorderLayout.EAST);

        Box boutons = Box.createHorizontalBox();
        JPanel classe = new JPanel();
        JPanel matiere = new JPanel();

        // event listener bouton modifier / consulter
        JButton modify;
        if(this.utilisateur.getPrivilege().getId_privilege()==1){
            modify = new JButton("Modifier / Consulter l'élève");
            modify.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleClick(1);
                }
            });
        }
        else{
            modify = new JButton("Consulter l'élève");
            modify.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleClick(0);
                }
            });
        }


        // On déclare et initialise deux comboBox
        classe.add(new JLabel("Classe : "));
        this.comboC = new JComboBox();
        matiere.add(new JLabel("Matière : "));
        this.comboM = new JComboBox();

        // Remplissage des comboBox
        ClasseService servC = new ClasseService();
        comboC.addItem(null);
        for( Classe c : servC.getAllClasses()){
            comboC.addItem(c);
        }
        classe.add(comboC);

        MatiereService servM = new MatiereService();
        Classe current = (Classe) comboC.getSelectedItem();
        comboM.addItem(null);
        for(Matiere m : servM.getMatieres(current)){
            comboM.addItem(m);
        }
        matiere.add(comboM);

        // on affecte la méthode handleComboChange aux comboBox
        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleComboChange();
            }
        };

        this.comboC.addActionListener(action);
        this.comboM.addActionListener(action);

        // On ajoute les combo et le bouton à l'objet Box
        boutons.add(classe);
        boutons.add(matiere);
        boutons.add(modify);

        // Génération Grille

        this.tableau = new JTable();
        this.controller.handleComboChange(this);
        tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane grille = new JScrollPane(tableau);
        
        aca.setLayout(new BoxLayout(aca,BoxLayout.PAGE_AXIS));
        aca.add(bl);
        aca.add(boutons);
        aca.add(grille);
        // Panel administratif




        onglet.addTab("Gestion académique",aca);
        onglet.addTab("Gestion administrative",admin);
        this.getContentPane().add(onglet);
        this.setVisible(true);
    }

    private void handleClosing(){
        this.controller.handleClosing(this);
    }

    private void handleClick(int privilege){
        this.controller.handleClickUser(this,privilege);
    }

    private void handleComboChange(){
        this.controller.handleComboChange(this);
    }

    public JTabbedPane getOnglet() {
        return onglet;
    }

    public void setOnglet(JTabbedPane onglet) {
        this.onglet = onglet;
    }

    public JTable getTableau() {
        return tableau;
    }

    public void setTableau(JTable tableau) {
        this.tableau = tableau;
    }

    public JComboBox<Classe> getComboC() {
        return comboC;
    }

    public void setComboC(JComboBox<Classe> comboC) {
        this.comboC = comboC;
    }

    public JComboBox<Matiere> getComboM() {
        return comboM;
    }

    public void setComboM(JComboBox<Matiere> comboM) {
        this.comboM = comboM;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String[] getNoms() {
        return noms;
    }




}
