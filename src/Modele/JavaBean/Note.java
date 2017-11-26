package Modele.JavaBean;

public class Note {
  private int id_note;
  private float coefficient;
  private Eleve eleve;
  private Matiere matiere;
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

  public Eleve getEleve() {
    return eleve;
  }

  public void setEleve(Eleve eleve) {
    this.eleve = eleve;
  }

  public Matiere getMatiere() {
    return matiere;
  }

  public void setMatiere(Matiere matiere) {
    this.matiere = matiere;
  }

  public float getNote() {
    return note;
  }

  public void setNote(float note) {
    this.note = note;
  }

  public String toString(){
    return Float.toString(this.note);
  }
}
