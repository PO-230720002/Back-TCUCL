package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.parametre.mobInternationale.VoyageVersUneDestinationMobInternationale;

import java.time.Year;
import java.util.List;

@Entity
@Table(name = "mob_international")
public class MobInternationalOnglet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Year annee;
    private boolean estTermine;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "voyage_mob_internationale_id")
    private List<VoyageVersUneDestinationMobInternationale> voyageVersUneDestinationMobInternationale;



    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }


    public Year getAnnee() {
        return annee;
    }

    public void setAnnee(Year annee) {
        this.annee = annee;
    }

    public boolean isEstTermine() {
        return estTermine;
    }

    public void setEstTermine(boolean estTermine) {
        this.estTermine = estTermine;
    }

    public List<VoyageVersUneDestinationMobInternationale> getVoyageVersUneDestinationMobInternationale() {
        return voyageVersUneDestinationMobInternationale;
    }

    public void setVoyageVersUneDestinationMobInternationale(List<VoyageVersUneDestinationMobInternationale> voyageVersUneDestinationMobInternationale) {
        this.voyageVersUneDestinationMobInternationale = voyageVersUneDestinationMobInternationale;
    }
}
