package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.MachineEmissionFugitive;

import java.time.Year;
import java.util.List;

@Entity
@Table(name = "emission_fugitive_onglet")
public class EmissionFugitiveOnglet extends Onglet {


    private boolean possedeClimatisation;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emission_fugitive_onglet_id")
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

    @Override
    public String getNote() {
        return super.getNote();
    }

    @Override
    public void setNote(String note) {
        super.setNote(note);
    }

    @Override
    public boolean isEstTermine() {
        return super.isEstTermine();
    }

    @Override
    public void setEstTermine(boolean estTermine) {
        super.setEstTermine(estTermine);
    }
}