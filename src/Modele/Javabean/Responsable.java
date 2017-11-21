package Modele.Javabean;

public class Responsable {
  private int id_responsable;
  private String prenom;
  private String nom;
  private String adresse;
  private String telephone;
  private String mail;
  private Eleve eleve;

  public Responsable(int id_responsable, String prenom, String nom, String adresse, String telephone, String mail, Eleve eleve) {
    this.id_responsable = id_responsable;
    this.prenom = prenom;
    this.nom = nom;
    this.adresse = adresse;
    this.telephone = telephone;
    this.mail = mail;
    this.eleve = eleve;
  }

  public Responsable(String prenom, String nom, String adresse, String telephone, String mail, Eleve eleve) {
    this.prenom = prenom;
    this.nom = nom;
    this.adresse = adresse;
    this.telephone = telephone;
    this.mail = mail;
    this.eleve = eleve;
  }

  public int getId_responsable() {
    return id_responsable;
  }

  public void setId_responsable(int id_responsable) {
    this.id_responsable = id_responsable;
  }

  public Eleve getEleve() {
    return eleve;
  }

  public void setEleve(Eleve eleve) {
    this.eleve = eleve;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }
}
