package Modele.JavaBean;

public class Note {
  private int id_note;
  private String libelle;
  private Double note;
  private int id_matiere;
  private int matricule;

  public int getId_note() {
    return id_note;
  }

  public void setId_note(int id_note) {
    this.id_note = id_note;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Double getNote() {
    return note;
  }

  public void setNote(Double note) {
    this.note = note;
  }

  public int getId_matiere() {
    return id_matiere;
  }

  public void setId_matiere(int id_matiere) {
    this.id_matiere = id_matiere;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }
}
