package tcucl.back_tcucl.entity;

import jakarta.persistence.*;
import tcucl.back_tcucl.config.AnneeConfig;
import tcucl.back_tcucl.entity.onglet.GeneralOnglet;
import tcucl.back_tcucl.entity.onglet.MobiliteDomicileTravailOnglet;
import tcucl.back_tcucl.entity.onglet.achat.AchatOnglet;
import tcucl.back_tcucl.entity.onglet.AutreImmobilisationOnglet;
import tcucl.back_tcucl.entity.onglet.AutreMobFrOnglet;
import tcucl.back_tcucl.entity.onglet.batiment.BatimentImmobilisationMobilierOnglet;
import tcucl.back_tcucl.entity.onglet.dechet.DechetOnglet;
import tcucl.back_tcucl.entity.onglet.emissionFugitive.EmissionFugitiveOnglet;
import tcucl.back_tcucl.entity.onglet.energie.EnergieOnglet;
import tcucl.back_tcucl.entity.onglet.mobInternationale.MobInternationalOnglet;
import tcucl.back_tcucl.entity.onglet.numerique.NumeriqueOnglet;
import tcucl.back_tcucl.entity.onglet.parkingVoirie.ParkingVoirieOnglet;
import tcucl.back_tcucl.entity.onglet.vehicule.VehiculeOnglet;

@Entity
@Table(name = "annee")
public class Annee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int anneeValeur;

    @OneToOne(cascade = CascadeType.ALL)
    private GeneralOnglet generalOnglet = new GeneralOnglet();
    @OneToOne(cascade = CascadeType.ALL)
    private EnergieOnglet energieOnglet = new EnergieOnglet();
    @OneToOne(cascade = CascadeType.ALL)
    private AchatOnglet achatOnglet = new AchatOnglet();
    @OneToOne(cascade = CascadeType.ALL)
    private AutreImmobilisationOnglet autreImmobilisationOnglet = new AutreImmobilisationOnglet();
    @OneToOne(cascade = CascadeType.ALL)
    private AutreMobFrOnglet autreMobFrOnglet = new AutreMobFrOnglet();
    @OneToOne(cascade = CascadeType.ALL)
    private BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = new BatimentImmobilisationMobilierOnglet();
    @OneToOne(cascade = CascadeType.ALL)
    private DechetOnglet dechetOnglet = new DechetOnglet();
    @OneToOne(cascade = CascadeType.ALL)
    private EmissionFugitiveOnglet emissionFugitiveOnglet = new EmissionFugitiveOnglet();
    @OneToOne(cascade = CascadeType.ALL)
    private MobiliteDomicileTravailOnglet mobiliteDomicileTravailOnglet = new MobiliteDomicileTravailOnglet();
    @OneToOne(cascade = CascadeType.ALL)
    private MobInternationalOnglet mobInternationalOnglet = new MobInternationalOnglet();
    @OneToOne(cascade = CascadeType.ALL)
    private NumeriqueOnglet numeriqueOnglet = new NumeriqueOnglet();
    @OneToOne(cascade = CascadeType.ALL)
    private ParkingVoirieOnglet parkingVoirieOnglet = new ParkingVoirieOnglet();
    @OneToOne(cascade = CascadeType.ALL)
    private VehiculeOnglet vehiculeOnglet = new VehiculeOnglet();

    @ManyToOne
    @JoinColumn(name = "entite_id")
    private Entite entite;

    public Annee() {
        this.anneeValeur = AnneeConfig.getAnneeCourante();
    }

    public Annee(int anneeValeur) {
        this.anneeValeur = anneeValeur;
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

    public MobiliteDomicileTravailOnglet getMobiliteDomicileTravailOnglet() {
        return mobiliteDomicileTravailOnglet;
    }

    public void setMobiliteDomicileTravailOnglet(MobiliteDomicileTravailOnglet mobiliteDomicileTravailOnglet) {
        this.mobiliteDomicileTravailOnglet = mobiliteDomicileTravailOnglet;
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
