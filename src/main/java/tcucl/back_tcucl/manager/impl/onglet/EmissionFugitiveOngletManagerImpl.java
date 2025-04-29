package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tcucl.back_tcucl.dto.MachineEmissionFugitiveDto;
import tcucl.back_tcucl.entity.onglet.EmissionFugitiveOnglet;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.MachineEmissionFugitive;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.enums.EnumEmissionFugitive_TypeFluide;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.enums.EnumEmissionFugitive_TypeMachine;
import tcucl.back_tcucl.manager.EmissionFugitiveOngletManager;
import tcucl.back_tcucl.repository.onglet.EmissionFugitiveOngletRepository;

@Component
public class EmissionFugitiveOngletManagerImpl implements EmissionFugitiveOngletManager {

    private final EmissionFugitiveOngletRepository emissionFugitiveOngletRepository;

    public EmissionFugitiveOngletManagerImpl(EmissionFugitiveOngletRepository emissionFugitiveOngletRepository) {
        this.emissionFugitiveOngletRepository = emissionFugitiveOngletRepository;
    }

    @Override
    public EmissionFugitiveOnglet getEmissionFugitiveOngletById(Long id) {
        return emissionFugitiveOngletRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("EmissionFugitiveOnglet non trouvé avec l'ID : " + id));
    }

    @Override
    public MachineEmissionFugitive getMachineById(Long ongletId, Long machineId) {
        EmissionFugitiveOnglet onglet = getEmissionFugitiveOngletById(ongletId);
        return onglet.getMachinesEmissionFugitive().stream()
                .filter(m -> m.getId().equals(machineId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Machine not found with ID: " + machineId));
    }

    @Override
    public void ajouterMachine(Long id, MachineEmissionFugitiveDto machineEmissionFugitiveDto) {
        EmissionFugitiveOnglet emissionFugitiveOnglet = getEmissionFugitiveOngletById(id);
        if (emissionFugitiveOnglet != null) {
            emissionFugitiveOnglet.ajouterMachineViaDto(machineEmissionFugitiveDto);
            emissionFugitiveOngletRepository.save(emissionFugitiveOnglet);
        } else {
            throw new IllegalArgumentException("Emission Fugitive Onglet not found with id: " + id);
        }
    }


    @Override
    public void supprimerMachineFromOnglet(Long ongletId, Long machineId) {
        EmissionFugitiveOnglet onglet = getEmissionFugitiveOngletById(ongletId);

        // Trouver la machine à supprimer
        MachineEmissionFugitive machineASupprimer = getMachineById(ongletId, machineId);

        // Retirer de la liste
        onglet.getMachinesEmissionFugitive().remove(machineASupprimer);

        // Sauvegarder l'onglet
        emissionFugitiveOngletRepository.save(onglet);
    }

    @Override
    public void setNomMachine(Long ongletId, Long machineId, String nomMachine) {
        MachineEmissionFugitive machine = getMachineById(ongletId, machineId);
        machine.setNomMachine(nomMachine);
        emissionFugitiveOngletRepository.save(getEmissionFugitiveOngletById(ongletId)); 
    }

    @Override
    public void setDescriptionMachine(Long ongletId, Long machineId, String descriptionMachine) {
        MachineEmissionFugitive machine = getMachineById(ongletId, machineId);
        machine.setDescriptionMachine(descriptionMachine);
        emissionFugitiveOngletRepository.save(getEmissionFugitiveOngletById(ongletId)); 
    }

    @Override
    public void setValeurEnumTypeFluide(Long ongletId, Long machineId, EnumEmissionFugitive_TypeFluide typeFluide) {
        MachineEmissionFugitive machine = getMachineById(ongletId, machineId);
        machine.setTypeFluide(typeFluide);
        emissionFugitiveOngletRepository.save(getEmissionFugitiveOngletById(ongletId)); 
    }

    @Override
    public void setQuantiteFluideKg(Long ongletId, Long machineId, Float quantiteFluideKg) {
        MachineEmissionFugitive machine = getMachineById(ongletId, machineId);
        machine.setQuantiteFluideKg(quantiteFluideKg);
        emissionFugitiveOngletRepository.save(getEmissionFugitiveOngletById(ongletId)); 
    }

    @Override
    public void setTauxDeFuiteConnu(Long ongletId, Long machineId, Boolean tauxDeFuiteConnu) {
        MachineEmissionFugitive machine = getMachineById(ongletId, machineId);
        machine.setTauxDeFuiteConnu(tauxDeFuiteConnu);
        if(tauxDeFuiteConnu){
            machine.setTauxDeFuite(null);
        }else{
            machine.setTypeMachine(null);
        }
        emissionFugitiveOngletRepository.save(getEmissionFugitiveOngletById(ongletId)); 
    }

    @Override
    public void setTauxDeFuite(Long ongletId, Long machineId, Float tauxDeFuite) {
        MachineEmissionFugitive machine = getMachineById(ongletId, machineId);
        machine.setTauxDeFuite(tauxDeFuite);
        emissionFugitiveOngletRepository.save(getEmissionFugitiveOngletById(ongletId)); 
    }

    @Override
    public void setValeurEnumTypeMachine(Long ongletId, Long machineId, EnumEmissionFugitive_TypeMachine typeMachine) {
        MachineEmissionFugitive machine = getMachineById(ongletId, machineId);
        machine.setTypeMachine(typeMachine);

        emissionFugitiveOngletRepository.save(getEmissionFugitiveOngletById(ongletId)); 
    }
}
