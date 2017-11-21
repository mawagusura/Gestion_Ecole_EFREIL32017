package Modele.Javabean;

public class Suit {
  private Double coefficient;
  private Eleve eleve;
  private Matiere matiere;

  public Double getCoefficient() {
    return coefficient;
  }

  public void setCoefficient(Double coefficient) {
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
}
