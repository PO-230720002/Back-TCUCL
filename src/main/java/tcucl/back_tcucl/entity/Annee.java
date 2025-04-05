package tcucl.back_tcucl.entity;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.onglet.*;

import java.time.Year;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Annee {

    @Id
    private Long id;
    private Year annee;

    @OneToOne
    private GeneralOnglet  generalOnglet;
    @OneToOne
    private EnergieOnglet energieOnglet;
    @OneToOne
    private AchatOnglet achatOnglet;
    @OneToOne
    private AutreImmobilisationOnglet autreImmobilisationOnglet;
    @OneToOne
    private AutreMobFrOnglet autreMobFrOnglet;
    @OneToOne
    private BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet;
    @OneToOne
    private DechetOnglet dechetOnglet;
    @OneToOne
    private EmissionFugitiveOnglet emissionFugitiveOnglet;
    @OneToOne
    private MobiliteDomTravOnglet mobiliteDomTravOnglet;
    @OneToOne
    private MobInternationalOnglet mobInternationalOnglet;
    @OneToOne
    private NumeriqueOnglet numeriqueOnglet;
    @OneToOne
    private ParkingVoirieOnglet parkingVoirieOnglet;
    @OneToOne
    private VehiculeOnglet vehiculeOnglet;

    public Annee() {
        this.annee = Year.now();
        this.generalOnglet = new GeneralOnglet();
        this.energieOnglet = new EnergieOnglet();
        this.achatOnglet = new AchatOnglet();
        this.autreImmobilisationOnglet = new AutreImmobilisationOnglet();
        this.autreMobFrOnglet = new AutreMobFrOnglet();
        this.batimentImmobilisationMobilierOnglet = new BatimentImmobilisationMobilierOnglet();
        this.dechetOnglet = new DechetOnglet();
        this.emissionFugitiveOnglet = new EmissionFugitiveOnglet();
        this.mobiliteDomTravOnglet = new MobiliteDomTravOnglet();
        this.mobInternationalOnglet = new MobInternationalOnglet();
        this.numeriqueOnglet = new NumeriqueOnglet();
        this.parkingVoirieOnglet = new ParkingVoirieOnglet();
        this.vehiculeOnglet = new VehiculeOnglet();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
