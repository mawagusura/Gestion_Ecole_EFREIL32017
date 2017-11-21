package Modele.Javabean;

public class Niveau_classe {
    private int id_niveau;
    private String nom;

    public Niveau_classe(int id_niveau, String nom) {
        this.id_niveau = id_niveau;
        this.nom = nom;
    }

    public Niveau_classe(String nom) {
        this.nom = nom;
    }

    public int getId_niveau() {
        return id_niveau;
    }

    public void setId_niveau(int id_niveau) {
        this.id_niveau = id_niveau;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
