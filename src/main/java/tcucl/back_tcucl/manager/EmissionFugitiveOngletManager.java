package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.dto.onglet.MachineEmissionFugitiveDto;
import tcucl.back_tcucl.dto.onglet.EmissionFugitiveOngletDto;
import tcucl.back_tcucl.entity.onglet.EmissionFugitiveOnglet;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.MachineEmissionFugitive;

public interface EmissionFugitiveOngletManager {

    EmissionFugitiveOnglet getEmissionFugitiveOngletById(Long id);

    void updateEmissionFugitiveOnglet(Long id, EmissionFugitiveOngletDto emissionFugitiveOngletDto);

    MachineEmissionFugitive getMachineById(Long ongletId, Long machineId);

    void ajouterMachine(Long id, MachineEmissionFugitiveDto machineEmissionFugitiveDto);

    void supprimerMachineFromOnglet(Long ongletId, Long machineId);

    void updateMachinePartiel(Long ongletId, Long machineId, MachineEmissionFugitiveDto machineEmissionFugitiveDto);
}
