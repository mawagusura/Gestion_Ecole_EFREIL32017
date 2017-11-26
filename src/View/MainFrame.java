package View;

import Controller.Controller;
import Modele.JavaBean.Classe;
import Modele.JavaBean.Eleve;
import Modele.JavaBean.Matiere;
import Modele.JavaBean.Utilisateur;
import Modele.Services.ClasseService;
import Modele.Services.EleveService;
import Modele.Services.MatiereService;
import Modele.Services.UtilisateurService;

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
        JButton modify = new JButton("Modifier / Consulter");

        // event listener bouton modifier
        modify.addActionListener(new AbstractAction() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 handleClick();
             }
        });


        // On déclare et initialise deux comboBox
        classe.add(new JLabel("Classe : "));
        this.comboC = new JComboBox();
        matiere.add(new JLabel("Matière : "));
        this.comboM = new JComboBox();

        // Remplissage des comboBox
        ClasseService servC = new ClasseService();
        for( Classe c : servC.getAllClasses()){
            comboC.addItem(c);
        }
        classe.add(comboC);

        MatiereService servM = new MatiereService();
        Classe current = (Classe) comboC.getSelectedItem();
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

        handleComboChange();
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

    /**
     * Méthode qui gère l'event de fermeture de la fenetre.
     * Demande une confirmation à l'utilisateur
     */
    private void handleClosing() {
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Etes vous sur de vouloir quitter ?", "Quitter ?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(option == JOptionPane.OK_OPTION){
            this.dispose();
        }
    }

    /**
     * Méthode gérant le clic sur le bouton Modifier / consulter.
     * Lance une nouvelle fenêtre si une ligne du tableau est sélectionnée.
     */
    private void handleClick(){
        if(this.tableau.getSelectedRow()!= -1) {
            System.out.println("Selected");
        }
    }

    /**
     * Méthode qui gère le changement d'état des comboBox.
     * Met à jour le tableau des éleves
     */
    private void handleComboChange(){
        Classe currC =(Classe) this.comboC.getSelectedItem();
        Matiere currM = (Matiere) this.comboM.getSelectedItem();

        EleveService servE = new EleveService();
        ArrayList<Eleve> eleves = servE.getEleves(currC,currM);

        Object[][] data = new Object[eleves.size()][4];

        for(int i=0;i<eleves.size();i++){
            Eleve e = eleves.get(i);
            data[i][0] = e.getPrenom();
            data[i][1] = e.getNom();
            data[i][2] = e.getSexe();
            data[i][3] = e.getClasse();
        }

        AcaModel model = new AcaModel(data,this.noms);
        this.tableau = new JTable(model);


    }

    /**
     * Classe interne pour gérer le modèle d'affichage des données académiques dans le tableau.
     */
    class AcaModel extends AbstractTableModel{
        private Object[][] data;
        private String[] title;

        //Constructeur
        public AcaModel(Object[][] data, String[] title){
            this.data = data;
            this.title = title;
        }

        //Retourne le nombre de colonnes
        @Override
        public int getColumnCount() {
            return this.title.length;
        }

        //Retourne le nombre de lignes
        @Override
        public int getRowCount() {
            return this.data.length;
        }

        //Retourne la valeur à l'emplacement spécifié
        @Override
        public Object getValueAt(int row, int col) {
            return this.data[row][col];
        }

        @Override
        public String getColumnName(int column) {
            return this.title[column];
        }
    }


}
