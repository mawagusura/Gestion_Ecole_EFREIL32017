package View;

import Controller.Controller;
import Modele.JavaBean.Eleve;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConsultView extends AbstractPopup {

    private final JTextField nom, prenom, adresse, ville_naissance, date_inscription, etablissement_prec,
    date_naissance;

    private final JComboBox sexe;

    public ConsultView(int privilege, Eleve eleve, Controller controller, MainFrame mainFrame){

        super(privilege,eleve,controller,mainFrame);

        JPanel mainPanel = new JPanel();
        GridLayout gl = new GridLayout(4,8);
        mainPanel.setLayout(gl);

        //Textfields
        mainPanel.add(new JLabel("Nom :"));
        this.nom = new JTextField(this.eleve.getNom());
        this.nom.setPreferredSize(new Dimension(100,30));
        mainPanel.add(this.nom);

        mainPanel.add(new JLabel("Prénom : "));
        this.prenom = new JTextField(this.eleve.getPrenom());
        this.prenom.setPreferredSize(new Dimension(100,30));
        mainPanel.add(this.prenom);

        mainPanel.add(new JLabel("Adresse :"));
        this.adresse = new JTextField(this.eleve.getCoord().getAdresse());
        this.adresse.setPreferredSize(new Dimension(100,30));
        mainPanel.add(this.adresse);

        mainPanel.add(new JLabel("Ville de naissance :"));
        this.ville_naissance = new JTextField(this.eleve.getVille_naissance());
        this.ville_naissance.setPreferredSize(new Dimension(100,30));
        mainPanel.add(this.ville_naissance);

        mainPanel.add(new JLabel("Sexe :"));
        this.sexe = new JComboBox();
        this.sexe.addItem("Homme");
        this.sexe.addItem("Femme");
        this.sexe.setSelectedItem(this.eleve.getSexe()==1 ? "Homme" : "Femme");
        this.sexe.setPreferredSize(new Dimension(100,30));
        mainPanel.add(this.sexe);

        mainPanel.add(new JLabel("Date d'inscription :"));
        this.date_inscription = new JTextField(this.eleve.getDate_inscription().toString());
        this.date_inscription.setPreferredSize(new Dimension(100,30));
        mainPanel.add(this.date_inscription);

        mainPanel.add(new JLabel("Etablissement précédent :"));
        this.etablissement_prec = new JTextField(this.eleve.getEtablissement_precedent());
        this.etablissement_prec.setPreferredSize(new Dimension(100,20));
        mainPanel.add(this.etablissement_prec);

        mainPanel.add(new JLabel("Date de naissance :"));
        this.date_naissance = new JTextField(this.eleve.getDate_naissance().toString());
        mainPanel.add(this.date_naissance);

        JPanel wrapper = new JPanel();
        wrapper.add(mainPanel);
        wrapper.setLayout(new BoxLayout(wrapper,BoxLayout.PAGE_AXIS));

        if(this.privilege==1) {
            JButton b = new JButton("Valider les modifications");
            b.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleValidation();
                }
            });
            JPanel jpp = new JPanel();
            jpp.add(b);
            wrapper.add(jpp);
        }
        else{
            disableAll();
        }
        this.getContentPane().add(wrapper);
        this.setVisible(true);
    }

    private void disableAll(){
        this.nom.setEditable(false);
        this.prenom.setEditable(false);
        this.adresse.setEditable(false);
    }

    private void handleValidation(){
        this.controller.handleValidation(this, true);
    }

    /**
     * Getters & setters
     */
    public JTextField getNom() {
        return nom;
    }

    public JTextField getPrenom() {
        return prenom;
    }

    public JTextField getAdresse() {
        return adresse;
    }

    public JTextField getVille_naissance() {
        return ville_naissance;
    }

    public JTextField getDate_inscription() {
        return date_inscription;
    }

    public JTextField getEtablissement_prec() {
        return etablissement_prec;
    }

    public JTextField getDate_naissance() {
        return date_naissance;
    }

    public JComboBox getSexe() {
        return sexe;
    }
}
