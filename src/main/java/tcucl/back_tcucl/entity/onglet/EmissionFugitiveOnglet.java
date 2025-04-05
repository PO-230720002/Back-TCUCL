package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.MachineEmissionFugitive;

import java.time.Year;
import java.util.List;

@Entity
@Table(name = "emission_fugitive")
public class EmissionFugitiveOnglet extends Onglet {


    private boolean possedeClimatisation;

    @ManyToMany
    @JoinTable(
            name = "jointure_EmissionFugitiveOnglet_MachineEmissionFugitive",
            joinColumns = @JoinColumn(name = "onglet_id"),
            inverseJoinColumns = @JoinColumn(name = "machine_id")
    )
    private List<MachineEmissionFugitive> machinesEmissionFugitive;




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


}
