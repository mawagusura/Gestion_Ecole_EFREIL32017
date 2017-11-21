package Modele.Javabean;

public class Classe {
    private int id_classe;
    private String nom;
    private Niveau_classe niveau;

    public Classe(String nom, Niveau_classe niveau) {
        this.nom = nom;
        this.niveau = niveau;
    }

    public Classe(int id_classe, String nom, Niveau_classe niveau) {
        this.id_classe = id_classe;
        this.nom = nom;
        this.niveau = niveau;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Niveau_classe getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau_classe niveau) {
        this.niveau = niveau;
    }
}
