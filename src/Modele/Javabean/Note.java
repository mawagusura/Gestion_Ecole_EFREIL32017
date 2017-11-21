package Modele.Javabean;

public class Note {
  private int id_note;
  private String libelle;
  private Double note;
  private Matiere matiere;
  private Eleve eleve;

  public Note(int id_note, String libelle, Double note, Matiere matiere, Eleve eleve) {
    this.id_note = id_note;
    this.libelle = libelle;
    this.note = note;
    this.matiere = matiere;
    this.eleve = eleve;
  }

  public Note(String libelle, Double note, Matiere matiere, Eleve eleve) {
    this.libelle = libelle;
    this.note = note;
    this.matiere = matiere;
    this.eleve = eleve;
  }

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

  public Matiere getMatiere() {
    return matiere;
  }

  public void setMatiere(Matiere matiere) {
    this.matiere = matiere;
  }

  public Eleve getEleve() {
    return eleve;
  }

  public void setEleve(Eleve eleve) {
    this.eleve = eleve;
  }
}
