package Modele.JavaBean;

public class Note {
  private int id_note;
  private float coefficient;
  private int matricule;
  private int id_matiere;
  private float note;

  public int getId_note() {
    return id_note;
  }

  public void setId_note(int id_note) {
    this.id_note = id_note;
  }

  public float getCoefficient() {
    return coefficient;
  }

  public void setCoefficient(float coefficient) {
    this.coefficient = coefficient;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public int getId_matiere() {
    return id_matiere;
  }

  public void setId_matiere(int id_matiere) {
    this.id_matiere = id_matiere;
  }

  public float getNote() {
    return note;
  }

  public void setNote(float note) {
    this.note = note;
  }
}
