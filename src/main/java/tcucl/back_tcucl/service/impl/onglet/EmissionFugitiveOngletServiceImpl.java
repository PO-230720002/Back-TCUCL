package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.emissionFugitive.MachineEmissionFugitiveDto;
import tcucl.back_tcucl.dto.onglet.emissionFugitive.EmissionFugitiveOngletDto;
import tcucl.back_tcucl.entity.onglet.EmissionFugitiveOnglet;
import tcucl.back_tcucl.manager.EmissionFugitiveOngletManager;
import tcucl.back_tcucl.service.EmissionFugitiveOngletService;

@Service
public class EmissionFugitiveOngletServiceImpl implements EmissionFugitiveOngletService {


    private final EmissionFugitiveOngletManager emissionFugitiveOngletManager;

    public EmissionFugitiveOngletServiceImpl(EmissionFugitiveOngletManager emissionFugitiveOngletManager) {
        this.emissionFugitiveOngletManager = emissionFugitiveOngletManager;
    }

    @Override
    public EmissionFugitiveOnglet getEmissionFugitiveOngletById(Long id) {
        return emissionFugitiveOngletManager.getEmissionFugitiveOngletById(id);
    }

    @Override
    public void updateEmissionFugitiveOnglet(Long id, EmissionFugitiveOngletDto emissionFugitiveOngletDto) {
        emissionFugitiveOngletManager.updateEmissionFugitiveOnglet(id, emissionFugitiveOngletDto);
    }

    @Override
    public void ajouterMachine(Long id, MachineEmissionFugitiveDto machineEmissionFugitiveDto) {
        emissionFugitiveOngletManager.ajouterMachine(id, machineEmissionFugitiveDto);
    }

    @Override
    public void supprimerMachine(Long ongletId, Long idMachine) {
        emissionFugitiveOngletManager.supprimerMachineFromOnglet(ongletId, idMachine);
    }

    @Override
    public void updateMachinePartiel(Long ongletId, Long machineId, MachineEmissionFugitiveDto machineEmissionFugitiveDto) {
        emissionFugitiveOngletManager.updateMachinePartiel(ongletId, machineId, machineEmissionFugitiveDto);
    }

}
