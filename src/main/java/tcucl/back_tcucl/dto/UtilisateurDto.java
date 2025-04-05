package tcucl.back_tcucl.dto;

public class UtilisateurDto {

    private long id;
    private String nom;
    private String prenom;
    private String email;
    private Boolean estAdmin;


    public UtilisateurDto(long id, String nom, String prenom, String email, Boolean estAdmin) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.estAdmin = estAdmin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEstAdmin() {
        return estAdmin;
    }

    public void setEstAdmin(Boolean estAdmin) {
        this.estAdmin = estAdmin;
    }


}
