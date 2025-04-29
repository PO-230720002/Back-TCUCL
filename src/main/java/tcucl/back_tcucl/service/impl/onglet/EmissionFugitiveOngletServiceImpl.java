package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.MachineEmissionFugitiveDto;
import tcucl.back_tcucl.entity.onglet.EmissionFugitiveOnglet;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.enums.EnumEmissionFugitive_TypeFluide;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.enums.EnumEmissionFugitive_TypeMachine;
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
    public void ajouterMachine(Long id, MachineEmissionFugitiveDto machineEmissionFugitiveDto) {
        emissionFugitiveOngletManager.ajouterMachine(id, machineEmissionFugitiveDto);
    }

    @Override
    public void supprimerMachine(Long ongletId, Long idMachine) {
        emissionFugitiveOngletManager.supprimerMachineFromOnglet(ongletId, idMachine);
    }

    @Override
    public void setNomMachine(Long ongletId, Long machineId, String nomMachine) {
        emissionFugitiveOngletManager.setNomMachine(ongletId, machineId, nomMachine);
    }

    @Override
    public void setDescriptionMachine(Long ongletId, Long machineId, String descriptionMachine) {
        emissionFugitiveOngletManager.setDescriptionMachine(ongletId,machineId, descriptionMachine);
    }

    @Override
    public void setValeurEnumTypeFluide(Long ongletId, Long machineId, EnumEmissionFugitive_TypeFluide typeFluide) {
        emissionFugitiveOngletManager.setValeurEnumTypeFluide(ongletId, machineId, typeFluide);
    }

    @Override
    public void setQuantiteFluideKg(Long ongletId, Long machineId, Float quantiteFluideKg) {
        emissionFugitiveOngletManager.setQuantiteFluideKg(ongletId, machineId, quantiteFluideKg);
    }

    @Override
    public void setTauxDeFuiteConnu(Long ongletId, Long machineId, Boolean tauxDeFuiteConnu) {
        emissionFugitiveOngletManager.setTauxDeFuiteConnu(ongletId, machineId, tauxDeFuiteConnu);
    }

    @Override
    public void setTauxDeFuite(Long ongletId, Long machineId, Float tauxDeFuite) {
        emissionFugitiveOngletManager.setTauxDeFuite(ongletId, machineId, tauxDeFuite);
    }

    @Override
    public void setValeurEnumTypeMachine(Long ongletId, Long machineId, EnumEmissionFugitive_TypeMachine typeMachine) {
        emissionFugitiveOngletManager.setValeurEnumTypeMachine(ongletId, machineId, typeMachine);
    }
}
