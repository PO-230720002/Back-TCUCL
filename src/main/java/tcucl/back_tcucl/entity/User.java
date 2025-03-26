package tcucl.back_tcucl.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String email;
    private Boolean isFirstConnection;
    private String role;
    private Boolean isAdmin;
    private Boolean isSuperAdmin;
    @ManyToOne
    @JoinColumn(name = "entite_id")
    private Entite entite;

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

    public Entite getEntite() {
        return entite;
    }

    public void setEntite(Entite entite) {
        this.entite = entite;
    }
    public Boolean getIsFirstConnection()  {
        return isFirstConnection;
    }
    public void setIsFirstConnection(Boolean isFirstConnection) {
        this.isFirstConnection = isFirstConnection;
    }
    public Boolean getIsAdmin() {
        return isAdmin;
    }
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    public Boolean getIsSuperAdmin() {
        return isSuperAdmin;
    }
    public void setIsSuperAdmin(boolean isSuperAdmin) {
        this.isSuperAdmin = isSuperAdmin;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", isFirstConnection='" + isFirstConnection + '\'' +
                ", isAdmin='" + isAdmin + '\'' +
                ", isSuperAdmin='" + isSuperAdmin + '\'' +
                '}';
    }
}