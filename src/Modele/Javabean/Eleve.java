package Modele.Javabean;

import java.sql.Date;

public class Eleve {
    private int matricule;
    private String ville_naissance;
    private String pays_naissance;
    private int sexe;
    private java.sql.Date date_inscription;
    private String etablissement_precedent;
    private java.sql.Date date_naissance;
    private String nom;
    private String prenom;
    private Coordonnees coord;
    private Carnet_sante sante;
    private Classe classe;

    public Eleve(String ville_naissance, String pays_naissance, int sexe, Date date_inscription, String etablissement_precedent, Date date_naissance, String nom, String prenom, Coordonnees coord, Carnet_sante sante, Classe classe) {
        this.ville_naissance = ville_naissance;
        this.pays_naissance = pays_naissance;
        this.sexe = sexe;
        this.date_inscription = date_inscription;
        this.etablissement_precedent = etablissement_precedent;
        this.date_naissance = date_naissance;
        this.nom = nom;
        this.prenom = prenom;
        this.coord = coord;
        this.sante = sante;
        this.classe = classe;
    }

    public Eleve(int matricule, String ville_naissance, String pays_naissance, int sexe, Date date_inscription, String etablissement_precedent, Date date_naissance, String nom, String prenom, Coordonnees coord, Carnet_sante sante, Classe classe) {
        this.matricule = matricule;
        this.ville_naissance = ville_naissance;
        this.pays_naissance = pays_naissance;
        this.sexe = sexe;
        this.date_inscription = date_inscription;
        this.etablissement_precedent = etablissement_precedent;
        this.date_naissance = date_naissance;
        this.nom = nom;
        this.prenom = prenom;
        this.coord = coord;
        this.sante = sante;
        this.classe = classe;
    }

    public int getMatricule() {
        return matricule;
    }

    public String getVille_naissance() {
        return ville_naissance;
    }

    public void setVille_naissance(String ville_naissance) {
        this.ville_naissance = ville_naissance;
    }

    public String getPays_naissance() {
        return pays_naissance;
    }

    public void setPays_naissance(String pays_naissance) {
        this.pays_naissance = pays_naissance;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public java.sql.Date getDate_inscription() {
        return date_inscription;
    }

    public void setDate_inscription(java.sql.Date date_inscription) {
        this.date_inscription = date_inscription;
    }

    public String getEtablissement_precedent() {
        return etablissement_precedent;
    }

    public void setEtablissement_precedent(String etablissement_precedent) {
        this.etablissement_precedent = etablissement_precedent;
    }

    public java.sql.Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(java.sql.Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Coordonnees getCoord() {
        return coord;
    }

    public void setCoord(Coordonnees coord) {
        this.coord = coord;
    }

    public Carnet_sante getSante() {
        return sante;
    }

    public void setSante(Carnet_sante sante) {
        this.sante = sante;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
