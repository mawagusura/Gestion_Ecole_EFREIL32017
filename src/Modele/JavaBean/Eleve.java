package Modele.JavaBean;

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
  private int id_coord;
  private int id_sante;
  private int id_classe;

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
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

  public int getId_coord() {
    return id_coord;
  }

  public void setId_coord(int id_coord) {
    this.id_coord = id_coord;
  }

  public int getId_sante() {
    return id_sante;
  }

  public void setId_sante(int id_sante) {
    this.id_sante = id_sante;
  }

  public int getId_classe() {
    return id_classe;
  }

  public void setId_classe(int id_classe) {
    this.id_classe = id_classe;
  }
}
