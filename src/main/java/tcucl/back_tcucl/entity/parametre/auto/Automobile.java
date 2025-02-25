package tcucl.back_tcucl.entity.parametre.auto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Year;

@Entity
@Table(name = "automobile")
public class Automobile {
    @Id
    private Long id;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
