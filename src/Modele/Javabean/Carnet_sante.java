package Modele.Javabean;

public class Carnet_sante {
    private int id_sante;
    private String medecin_traitement;
    private String telephone_medecin;
    private String vaccinations;
    private String allergies;
    private Eleve eleve;

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

    public String getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(String vaccinations) {
        this.vaccinations = vaccinations;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }
}
