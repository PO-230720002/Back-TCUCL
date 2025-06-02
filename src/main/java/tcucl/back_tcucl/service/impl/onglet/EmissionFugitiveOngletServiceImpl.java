package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.emissionFugitive.MachineEmissionFugitiveDto;
import tcucl.back_tcucl.dto.onglet.emissionFugitive.EmissionFugitiveOngletDto;
import tcucl.back_tcucl.entity.onglet.emissionFugitive.EmissionFugitiveOnglet;
import tcucl.back_tcucl.manager.EmissionFugitiveOngletManager;
import tcucl.back_tcucl.service.EmissionFugitiveOngletService;

@Service
public class EmissionFugitiveOngletServiceImpl implements EmissionFugitiveOngletService {


    private final EmissionFugitiveOngletManager emissionFugitiveOngletManager;

    public EmissionFugitiveOngletServiceImpl(EmissionFugitiveOngletManager emissionFugitiveOngletManager) {
        this.emissionFugitiveOngletManager = emissionFugitiveOngletManager;
    }

    @Override
    public EmissionFugitiveOnglet getEmissionFugitiveOngletById(Long ongletId) {
        return emissionFugitiveOngletManager.getEmissionFugitiveOngletById(ongletId);
    }

    @Override
    public void updateEmissionFugitiveOnglet(Long ongletId, EmissionFugitiveOngletDto emissionFugitiveOngletDto) {
        emissionFugitiveOngletManager.updateEmissionFugitiveOnglet(ongletId, emissionFugitiveOngletDto);
    }

    @Override
    public void ajouterMachine(Long ongletId, MachineEmissionFugitiveDto machineEmissionFugitiveDto) {
        emissionFugitiveOngletManager.ajouterMachine(ongletId, machineEmissionFugitiveDto);
    }

    @Override
    public void supprimerMachine(Long ongletId, Long machineId) {
        emissionFugitiveOngletManager.supprimerMachineFromOnglet(ongletId, machineId);
    }

    @Override
    public void updateMachinePartiel(Long ongletId, Long machineId, MachineEmissionFugitiveDto machineEmissionFugitiveDto) {
        emissionFugitiveOngletManager.updateMachinePartiel(ongletId, machineId, machineEmissionFugitiveDto);
    }

}
