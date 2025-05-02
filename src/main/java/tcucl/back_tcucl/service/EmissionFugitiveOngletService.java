package tcucl.back_tcucl.service;

import tcucl.back_tcucl.dto.onglet.emissionFugitive.MachineEmissionFugitiveDto;
import tcucl.back_tcucl.dto.onglet.emissionFugitive.EmissionFugitiveOngletDto;
import tcucl.back_tcucl.entity.onglet.emissionFugitive.EmissionFugitiveOnglet;

public interface EmissionFugitiveOngletService {

    EmissionFugitiveOnglet getEmissionFugitiveOngletById(Long id);

    void updateEmissionFugitiveOnglet(Long id, EmissionFugitiveOngletDto emissionFugitiveOngletDto);

    void ajouterMachine(Long id, MachineEmissionFugitiveDto machineEmissionFugitiveDto);

    void supprimerMachine(Long ongletId, Long idMachine);

    void updateMachinePartiel(Long ongletId, Long machineId, MachineEmissionFugitiveDto machineEmissionFugitiveDto);

}
