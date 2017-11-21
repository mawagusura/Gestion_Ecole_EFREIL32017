package Modele.Javabean;

public class Carnet_sante {
    private int id_sante;
    private String medecin_traitement;
    private String telephone_medecin;
    private String vaccinations;
    private String allergies;
    private Eleve eleve;

    public Carnet_sante(String medecin_traitement, String telephone_medecin, String vaccinations, String allergies, Eleve eleve) {
        this.medecin_traitement = medecin_traitement;
        this.telephone_medecin = telephone_medecin;
        this.vaccinations = vaccinations;
        this.allergies = allergies;
        this.eleve = eleve;
    }

    public Carnet_sante(int id_sante, String medecin_traitement, String telephone_medecin, String vaccinations, String allergies, Eleve eleve) {
        this.id_sante = id_sante;
        this.medecin_traitement = medecin_traitement;
        this.telephone_medecin = telephone_medecin;
        this.vaccinations = vaccinations;
        this.allergies = allergies;
        this.eleve = eleve;
    }

    public int getId_sante() {
        return id_sante;
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
