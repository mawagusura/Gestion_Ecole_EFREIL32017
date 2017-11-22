package Modele.JavaBean;

public class Carnet_sante {
  private int id_sante;
  private String medecin_traitement;
  private String telephone_medecin;
  private int vaccinations;
  private String allergies;
  private String remarques;

  public int getId_sante() {
    return id_sante;
  }

  public void setId_sante(int id_sante) {
    this.id_sante = id_sante;
  }

  public String getMedecin_traitement() {
    return medecin_traitement;
  }

  public void setMedecin_traitement(String medecin_traitement) {
    this.medecin_traitement = medecin_traitement;
  }

  public String getTelephone_medecin() {
    return telephone_medecin;
  }

  public void setTelephone_medecin(String telephone_medecin) {
    this.telephone_medecin = telephone_medecin;
  }

  public int getVaccinations() {
    return vaccinations;
  }

  public void setVaccinations(int vaccinations) {
    this.vaccinations = vaccinations;
  }

  public String getAllergies() {
    return allergies;
  }

  public void setAllergies(String allergies) {
    this.allergies = allergies;
  }

  public String getRemarques() {
    return remarques;
  }

  public void setRemarques(String remarques) {
    this.remarques = remarques;
  }
}
