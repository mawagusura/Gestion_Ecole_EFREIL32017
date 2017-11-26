package View;

import Controller.Controller;
import Modele.JavaBean.Classe;
import Modele.JavaBean.Matiere;
import Modele.JavaBean.Utilisateur;
import Modele.Services.ClasseService;
import Modele.Services.EleveService;
import Modele.Services.MatiereService;
import Modele.Services.UtilisateurService;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private JTabbedPane onglet = new JTabbedPane();
    private Controller controller;

    private Utilisateur utilisateur;

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

        classe.add(new JLabel("Classe : "));
        JComboBox<Classe> comboC = new JComboBox();

        // Remplissage des comboBox
        ClasseService servC = new ClasseService();
        for( Classe c : servC.getAllClasses()){
            comboC.addItem(c);
        }
        classe.add(comboC);

        MatiereService servM = new MatiereService();
        Classe actu = (Classe) comboC.getSelectedItem();
        //for(Matiere m : actu.)


        matiere.add(new JLabel("Matière : "));
        JComboBox comboM = new JComboBox();
        matiere.add(comboM);

        boutons.add(classe);
        boutons.add(matiere);
        boutons.add(modify);

        // Grille

        Object[][] data = new Object[50][4];
        String noms[] = {"Prénom","Nom","Sexe","Classe"};

        JTable tableau = new JTable(data,noms);
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

    public void handleClosing() {
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Etes vous sur de vouloir quitter ?", "Quitter ?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(option == JOptionPane.OK_OPTION){
            this.dispose();
        }
    }


}
