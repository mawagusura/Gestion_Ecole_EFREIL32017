package Modele.JavaBean;

public class Classe {
  private int id_classe;
  private String nom;
  private Niveau_classe niveau;

  public int getId_classe() {
    return id_classe;
  }

  public void setId_classe(int id_classe) {
    this.id_classe = id_classe;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Niveau_classe getNiveau() {
    return this.niveau;
  }

  public void setNiveau(Niveau_classe niveau) {
    this.niveau = niveau;
  }
}
