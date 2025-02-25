package tcucl.back_tcucl.entity;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.entite.Entite;

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
    @JoinColumn(name = "entity_id")
    private Entite entity;

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

    public Entite getEntity() {
        return entity;
    }

    public void setEntity(Entite entity) {
        this.entity = entity;
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
