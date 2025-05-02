package tcucl.back_tcucl.dto;

public class InscriptionDto {

    private String nom;
    private String prenom;
    private String email;
    private boolean estAdmin;
    private Long entiteId;


    public InscriptionDto(String nom, String prenom, String email, boolean estAdmin, Long entiteId) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.estAdmin = estAdmin;
        this.entiteId = entiteId;
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

    public boolean isEstAdmin() {
        return estAdmin;
    }

    public void setEstAdmin(boolean estAdmin) {
        this.estAdmin = estAdmin;
    }

    public Long getEntiteId() {
        return entiteId;
    }

    public void setEntiteId(Long entiteId) {
        this.entiteId = entiteId;
    }
}
