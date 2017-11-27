package View;

import Controller.Controller;
import Modele.JavaBean.Classe;
import Modele.JavaBean.Eleve;
import Modele.JavaBean.Matiere;
import Modele.JavaBean.Utilisateur;
import javax.swing.*;

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
    private JTable tableau2;
    private JComboBox<Classe> comboC;
    private JComboBox<Matiere> comboM;
    private JTextField texte;

    /**
     * Data Related attributes
     */
    private final Controller controller;
    private final Utilisateur utilisateur;
    private ArrayList<Eleve> elevesAdmin;
    private ArrayList<Eleve> elevesAca;
    private final String noms[] = {"Prénom","Nom","Sexe","Classe"};
    private final String noms2[] = {"Prénom","Nom","Sexe","Date Inscription"};

    /**
     * Constructeur qui dessine la fenetre principale
     * @param controller
     * @param user
     */
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
        this.setSize(900, 400);
        this.controller = controller;

        JPanel aca = new JPanel();

        // Panel académique
        JPanel bl = new JPanel();
        JLabel titre = new JLabel("Liste des élèves");
        JLabel util = new JLabel("Connecté en tant que : "+this.utilisateur.getNom()+" "+this.utilisateur.getPrenom());

        bl.add(titre);

        JPanel boutons = new JPanel();
        JPanel classe = new JPanel();
        JPanel matiere = new JPanel();

        // event listener bouton modifier / consulter
        JButton modify;
        if(this.utilisateur.getPrivilege().getId_privilege()==1){
            modify = new JButton("Modifier / Consulter l'élève");
            modify.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleClick(1,1);
                }
            });
        }
        else{
            modify = new JButton("Consulter l'élève");
            modify.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleClick(0,1);
                }
            });
        }


        // On déclare et initialise deux comboBox
        classe.add(new JLabel("Classe : "));
        this.comboC = new JComboBox();
        matiere.add(new JLabel("Matière : "));
        this.comboM = new JComboBox();

        // Remplissage des comboBox
        comboC.addItem(null);
        for( Classe c : this.controller.getClasseService().getAllClasses()){
            comboC.addItem(c);
        }
        classe.add(comboC);

        Classe current = (Classe) comboC.getSelectedItem();
        comboM.addItem(null);
        for(Matiere m : this.controller.getMatiereService().getMatieres(current)){
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
        onglet.addTab("Gestion académique",aca);


        drawAdmin();

        // bas de page et construction panel
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BorderLayout());
        JPanel pan = new JPanel();
        pan.setPreferredSize(new Dimension(100,30));
        pan.add(util);
        wrapper.add(onglet,BorderLayout.CENTER);
        wrapper.add(pan,BorderLayout.PAGE_END);

        this.getContentPane().add(wrapper);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void drawAdmin(){

        JPanel admin = new JPanel();

        JPanel bl = new JPanel();

        JLabel titre = new JLabel("Liste des élèves");

        bl.add(titre);

        JPanel boutons = new JPanel();

        JPanel search = new JPanel();
        JButton b = new JButton("Rechercher");
        b.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSearch();
            }
        });
        this.texte = new JTextField();
        this.texte.setPreferredSize(new Dimension(100,20));

        search.add(b);
        search.add(this.texte);

        boutons.add(search);
        // event listener bouton modifier / consulter
        JButton modify;
        if(this.utilisateur.getPrivilege().getId_privilege()==1){
            modify = new JButton("Modifier / Consulter l'élève");
            modify.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleClick(1,0);
                }
            });
        }
        else{
            modify = new JButton("Consulter l'élève");
            modify.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleClick(0,0);
                }
            });
        }

        // Panel administratif
        this.tableau2 = new JTable();

        this.controller.updateTabAdmin(this);

        tableau2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane grille2 = new JScrollPane(tableau2);

        boutons.add(modify);
        admin.setLayout(new BoxLayout(admin,BoxLayout.PAGE_AXIS));
        admin.add(bl);
        admin.add(boutons);

        admin.add(grille2);

        onglet.addTab("Gestion administrative",admin);

    }

    private void handleSearch(){
        this.controller.updateTabAdmin(this);
    }

    private void handleClosing(){
        this.controller.handleClosing(this);
    }

    private void handleClick(int privilege, int type){
        this.controller.handleClickUser(this,privilege,type);
    }

    private void handleComboChange(){
        this.controller.handleComboChange(this);
    }

    /**
     * Getters & setters
     * @return
     */

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


    public String[] getNoms() {
        return noms;
    }

    public JTable getTableau2() {
        return tableau2;
    }

    public JTextField getTexte() {
        return texte;
    }

    public ArrayList<Eleve> getElevesAdmin() {
        return elevesAdmin;
    }

    public ArrayList<Eleve> getElevesAca() {
        return elevesAca;
    }

    public void setElevesAdmin(ArrayList<Eleve> elevesAdmin) {
        this.elevesAdmin = elevesAdmin;
    }

    public void setElevesAca(ArrayList<Eleve> elevesAca) {
        this.elevesAca = elevesAca;
    }

    public String[] getNoms2() {
        return noms2;
    }
}
