package tcucl.back_tcucl.entity.onglet.emissionFugitive;

import jakarta.persistence.*;
import tcucl.back_tcucl.dto.onglet.emissionFugitive.MachineEmissionFugitiveDto;
import tcucl.back_tcucl.entity.onglet.Onglet;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "emission_fugitive_onglet")
public class EmissionFugitiveOnglet extends Onglet {


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "emission_fugitive_onglet_id")
    private List<MachineEmissionFugitive> machinesEmissionFugitive;

    public EmissionFugitiveOnglet() {
        this.machinesEmissionFugitive = new ArrayList<>();
    }

    public List<MachineEmissionFugitive> getMachinesEmissionFugitive() {
        return machinesEmissionFugitive;
    }

    public void setMachinesEmissionFugitive(List<MachineEmissionFugitive> machinesEmissionFugitive) {
        this.machinesEmissionFugitive = machinesEmissionFugitive;
    }

    public void ajouterMachineViaDto(MachineEmissionFugitiveDto machineEmissionFugitiveDto) {
        MachineEmissionFugitive machineEmissionFugitive = new MachineEmissionFugitive();

        machineEmissionFugitive.setDescriptionMachine(machineEmissionFugitiveDto.getDescriptionMachine());
        machineEmissionFugitive.setQuantiteFluideKg(machineEmissionFugitiveDto.getQuantiteFluideKg());
        machineEmissionFugitive.setTauxDeFuiteConnu(machineEmissionFugitiveDto.getTauxDeFuiteConnu());
        machineEmissionFugitive.setTauxDeFuite(machineEmissionFugitiveDto.getTauxDeFuite());
        machineEmissionFugitive.setTypeFluide(machineEmissionFugitiveDto.getTypeFluide());
        machineEmissionFugitive.setTypeMachine(machineEmissionFugitiveDto.getTypeMachine());

        this.machinesEmissionFugitive.add(machineEmissionFugitive);
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
    public Boolean getEstTermine() {
        return super.getEstTermine();
    }

    @Override
    public void setEstTermine(Boolean estTermine) {
        super.setEstTermine(estTermine);
    }
}