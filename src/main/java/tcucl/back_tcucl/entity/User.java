package tcucl.back_tcucl.entity;

import jakarta.persistence.*;
<<<<<<< Updated upstream
import tcucl.back_tcucl.entity.entite.Annee;
=======
>>>>>>> Stashed changes

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String email;
    private String role;

    @ManyToOne
<<<<<<< Updated upstream
    @JoinColumn(name = "annee_id")
    private Annee annee;
=======
    @JoinColumn(name = "entite_id")
    private Entite entite;
>>>>>>> Stashed changes

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role_tableRole;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

<<<<<<< Updated upstream
    public Annee getAnnee() {
        return annee;
    }

    public void setAnnee(Annee annee) {
        this.annee = annee;
=======
    public Entite getEntite() {
        return entite;
    }

    public void setEntite(Entite entite) {
        this.entite = entite;
>>>>>>> Stashed changes
    }

    public Role getRole_tableRole() {
        return role_tableRole;
    }

    public void setRole_tableRole(Role role_tableRole) {
        this.role_tableRole = role_tableRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
