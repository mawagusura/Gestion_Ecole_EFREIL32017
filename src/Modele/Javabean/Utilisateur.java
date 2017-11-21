package Modele.Javabean;

public class Utilisateur {
  private int id_utilisateur;
  private String mail;
  private String nom;
  private String prenom;
  private String hash_mdp;
  private Privilege privilege;

  public Utilisateur(int id_utilisateur, String mail, String nom, String prenom, String hash_mdp, Privilege privilege) {
    this.id_utilisateur = id_utilisateur;
    this.mail = mail;
    this.nom = nom;
    this.prenom = prenom;
    this.hash_mdp = hash_mdp;
    this.privilege = privilege;
  }

  public Utilisateur(String mail, String nom, String prenom, String hash_mdp, Privilege privilege) {
    this.mail = mail;
    this.nom = nom;
    this.prenom = prenom;
    this.hash_mdp = hash_mdp;
    this.privilege = privilege;
  }

  public int getId_utilisateur() {
    return id_utilisateur;
  }

  public void setId_utilisateur(int id_utilisateur) {
    this.id_utilisateur = id_utilisateur;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
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

  public String getHash_mdp() {
    return hash_mdp;
  }

  public void setHash_mdp(String hash_mdp) {
    this.hash_mdp = hash_mdp;
  }

  public Privilege getPrivilege() {
    return privilege;
  }

  public void setPrivilege(Privilege privilege) {
    this.privilege = privilege;
  }
}
