package Modele.Javabean;

public class Privilege {
    private int id_privilege;
    private String libelle;

    public Privilege(int id_privilege, String libelle) {
        this.id_privilege = id_privilege;
        this.libelle = libelle;
    }

    public Privilege(String libelle) {
        this.libelle = libelle;
    }

    public int getId_privilege() {
        return id_privilege;
    }

    public void setId_privilege(int id_privilege) {
        this.id_privilege = id_privilege;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
