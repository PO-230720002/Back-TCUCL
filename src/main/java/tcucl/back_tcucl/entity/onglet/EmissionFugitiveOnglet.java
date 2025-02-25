package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.MachineEmissionFugitive;

import java.time.Year;
import java.util.List;

@Entity
@Table(name = "emission_fugitive")
public class EmissionFugitiveOnglet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Year annee;
    private boolean estTermine;

    private boolean possedeClimatisation;

    @ManyToMany
    @JoinTable(
            name = "jointure_EmissionFugitiveOnglet_MachineEmissionFugitive",
            joinColumns = @JoinColumn(name = "onglet_id"),
            inverseJoinColumns = @JoinColumn(name = "machine_id")
    )
    private List<MachineEmissionFugitive> machinesEmissionFugitive;



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

    public boolean isPossedeClimatisation() {
        return possedeClimatisation;
    }

    public void setPossedeClimatisation(boolean possedeClimatisation) {
        this.possedeClimatisation = possedeClimatisation;
    }

    public List<MachineEmissionFugitive> getMachinesEmissionFugitive() {
        return machinesEmissionFugitive;
    }

    public void setMachinesEmissionFugitive(List<MachineEmissionFugitive> machinesEmissionFugitive) {
        this.machinesEmissionFugitive = machinesEmissionFugitive;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
