package Modele.Javabean;

public class Est_responsable_de {
  private Responsable responsable;
  private Eleve eleve;

  public Est_responsable_de(Responsable responsable, Eleve eleve) {
    this.responsable = responsable;
    this.eleve = eleve;
  }

  public Responsable getResponsable() {
    return responsable;
  }

  public void setResponsable(Responsable responsable) {
    this.responsable = responsable;
  }

  public Eleve getEleve() {
    return eleve;
  }

  public void setEleve(Eleve eleve) {
    this.eleve = eleve;
  }
}
