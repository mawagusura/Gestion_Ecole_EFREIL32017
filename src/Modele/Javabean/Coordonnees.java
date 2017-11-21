package Modele.Javabean;

public class Coordonnees {
    private int id_coord;
    private String adresse;
    private String ville;
    private String tel_mobile;
    private String tel_fixe;
    private String mail;
    private Eleve eleve;

    public Coordonnees(String adresse, String ville, String tel_mobile, String tel_fixe, String mail, Eleve eleve) {
        this.adresse = adresse;
        this.ville = ville;
        this.tel_mobile = tel_mobile;
        this.tel_fixe = tel_fixe;
        this.mail = mail;
        this.eleve = eleve;
    }

    public Coordonnees(int id_coord, String adresse, String ville, String tel_mobile, String tel_fixe, String mail, Eleve eleve) {
        this.id_coord = id_coord;
        this.adresse = adresse;
        this.ville = ville;
        this.tel_mobile = tel_mobile;
        this.tel_fixe = tel_fixe;
        this.mail = mail;
        this.eleve = eleve;
    }

    public int getId_coord() {
        return id_coord;
    }

    public void setId_coord(int id_coord) {
        this.id_coord = id_coord;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTel_mobile() {
        return tel_mobile;
    }

    public void setTel_mobile(String tel_mobile) {
        this.tel_mobile = tel_mobile;
    }

    public String getTel_fixe() {
        return tel_fixe;
    }

    public void setTel_fixe(String tel_fixe) {
        this.tel_fixe = tel_fixe;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }
}
