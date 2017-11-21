package Modele.Javabean;

public class Suit {
  private Double coefficient;
  private Eleve eleve;
  private Matiere matiere;

  public Suit(Double coefficient, Eleve eleve, Matiere matiere) {
    this.coefficient = coefficient;
    this.eleve = eleve;
    this.matiere = matiere;
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

  public Double getCoefficient() {
    return coefficient;
  }

  public void setCoefficient(Double coefficient) {
    this.coefficient = coefficient;
  }
}
