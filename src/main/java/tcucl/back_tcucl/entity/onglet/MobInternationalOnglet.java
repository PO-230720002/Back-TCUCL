package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.parametre.mobInternationale.VoyageVersUneDestinationMobInternationale;

import java.time.Year;
import java.util.List;

@Entity
@Table(name = "mob_international")
public class MobInternationalOnglet extends Onglet {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "voyage_mob_internationale_id")
    private List<VoyageVersUneDestinationMobInternationale> voyageVersUneDestinationMobInternationale;


    public List<VoyageVersUneDestinationMobInternationale> getVoyageVersUneDestinationMobInternationale() {
        return voyageVersUneDestinationMobInternationale;
    }

    public void setVoyageVersUneDestinationMobInternationale(List<VoyageVersUneDestinationMobInternationale> voyageVersUneDestinationMobInternationale) {
        this.voyageVersUneDestinationMobInternationale = voyageVersUneDestinationMobInternationale;
    }
}
