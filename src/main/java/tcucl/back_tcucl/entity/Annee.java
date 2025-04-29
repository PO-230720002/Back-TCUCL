package tcucl.back_tcucl.entity;

import jakarta.persistence.*;
import tcucl.back_tcucl.config.AnneeConfig;
import tcucl.back_tcucl.entity.onglet.*;

@Entity
@Table(name = "annee")
public class Annee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int anneeValeur;

    @OneToOne(cascade = CascadeType.ALL)
    private GeneralOnglet generalOnglet;
    @OneToOne(cascade = CascadeType.ALL)
    private EnergieOnglet energieOnglet;
    @OneToOne(cascade = CascadeType.ALL)
    private AchatOnglet achatOnglet;
    @OneToOne(cascade = CascadeType.ALL)
    private AutreImmobilisationOnglet autreImmobilisationOnglet;
    @OneToOne(cascade = CascadeType.ALL)
    private AutreMobFrOnglet autreMobFrOnglet;
    @OneToOne(cascade = CascadeType.ALL)
    private BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet;
    @OneToOne(cascade = CascadeType.ALL)
    private DechetOnglet dechetOnglet;
    @OneToOne(cascade = CascadeType.ALL)
    private EmissionFugitiveOnglet emissionFugitiveOnglet;
    @OneToOne(cascade = CascadeType.ALL)
    private MobiliteDomTravOnglet mobiliteDomTravOnglet;
    @OneToOne(cascade = CascadeType.ALL)
    private MobInternationalOnglet mobInternationalOnglet;
    @OneToOne(cascade = CascadeType.ALL)
    private NumeriqueOnglet numeriqueOnglet;
    @OneToOne(cascade = CascadeType.ALL)
    private ParkingVoirieOnglet parkingVoirieOnglet;
    @OneToOne(cascade = CascadeType.ALL)
    private VehiculeOnglet vehiculeOnglet;

    @ManyToOne
    @JoinColumn(name = "entite_id")
    private Entite entite;

    public Annee() {
        this.anneeValeur = AnneeConfig.getAnneeCourante();
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

    public Annee(int anneeValeur) {
        this.anneeValeur = anneeValeur;
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

    public int getAnneeValeur() {
        return anneeValeur;
    }

    public void setAnneeValeur(int annee) {
        this.anneeValeur = annee;
    }

    public GeneralOnglet getGeneralOnglet() {
        return generalOnglet;
    }

    public void setGeneralOnglet(GeneralOnglet generalOnglet) {
        this.generalOnglet = generalOnglet;
    }

    public EnergieOnglet getEnergieOnglet() {
        return energieOnglet;
    }

    public void setEnergieOnglet(EnergieOnglet energieOnglet) {
        this.energieOnglet = energieOnglet;
    }

    public AchatOnglet getAchatOnglet() {
        return achatOnglet;
    }

    public void setAchatOnglet(AchatOnglet achatOnglet) {
        this.achatOnglet = achatOnglet;
    }

    public AutreImmobilisationOnglet getAutreImmobilisationOnglet() {
        return autreImmobilisationOnglet;
    }

    public void setAutreImmobilisationOnglet(AutreImmobilisationOnglet autreImmobilisationOnglet) {
        this.autreImmobilisationOnglet = autreImmobilisationOnglet;
    }

    public AutreMobFrOnglet getAutreMobFrOnglet() {
        return autreMobFrOnglet;
    }

    public void setAutreMobFrOnglet(AutreMobFrOnglet autreMobFrOnglet) {
        this.autreMobFrOnglet = autreMobFrOnglet;
    }

    public BatimentImmobilisationMobilierOnglet getBatimentImmobilisationMobilierOnglet() {
        return batimentImmobilisationMobilierOnglet;
    }

    public void setBatimentImmobilisationMobilierOnglet(BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet) {
        this.batimentImmobilisationMobilierOnglet = batimentImmobilisationMobilierOnglet;
    }

    public DechetOnglet getDechetOnglet() {
        return dechetOnglet;
    }

    public void setDechetOnglet(DechetOnglet dechetOnglet) {
        this.dechetOnglet = dechetOnglet;
    }

    public EmissionFugitiveOnglet getEmissionFugitiveOnglet() {
        return emissionFugitiveOnglet;
    }

    public void setEmissionFugitiveOnglet(EmissionFugitiveOnglet emissionFugitiveOnglet) {
        this.emissionFugitiveOnglet = emissionFugitiveOnglet;
    }

    public MobiliteDomTravOnglet getMobiliteDomTravOnglet() {
        return mobiliteDomTravOnglet;
    }

    public void setMobiliteDomTravOnglet(MobiliteDomTravOnglet mobiliteDomTravOnglet) {
        this.mobiliteDomTravOnglet = mobiliteDomTravOnglet;
    }

    public MobInternationalOnglet getMobInternationalOnglet() {
        return mobInternationalOnglet;
    }

    public void setMobInternationalOnglet(MobInternationalOnglet mobInternationalOnglet) {
        this.mobInternationalOnglet = mobInternationalOnglet;
    }

    public NumeriqueOnglet getNumeriqueOnglet() {
        return numeriqueOnglet;
    }

    public void setNumeriqueOnglet(NumeriqueOnglet numeriqueOnglet) {
        this.numeriqueOnglet = numeriqueOnglet;
    }

    public ParkingVoirieOnglet getParkingVoirieOnglet() {
        return parkingVoirieOnglet;
    }

    public void setParkingVoirieOnglet(ParkingVoirieOnglet parkingVoirieOnglet) {
        this.parkingVoirieOnglet = parkingVoirieOnglet;
    }

    public VehiculeOnglet getVehiculeOnglet() {
        return vehiculeOnglet;
    }

    public void setVehiculeOnglet(VehiculeOnglet vehiculeOnglet) {
        this.vehiculeOnglet = vehiculeOnglet;
    }

    public Entite getEntite() {
        return entite;
    }

    public void setEntite(Entite entite) {
        this.entite = entite;
    }
}
