package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.emissionFugitive.MachineEmissionFugitiveDto;
import tcucl.back_tcucl.dto.onglet.emissionFugitive.EmissionFugitiveOngletDto;
import tcucl.back_tcucl.entity.onglet.EmissionFugitiveOnglet;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.MachineEmissionFugitive;
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
                .orElseThrow(() -> new EntityNotFoundException("EmissionFugitiveOnglet non trouvé avec l'Id : " + id));
    }

    @Override
    public MachineEmissionFugitive getMachineById(Long ongletId, Long machineId) {
        EmissionFugitiveOnglet onglet = getEmissionFugitiveOngletById(ongletId);
        return onglet.getMachinesEmissionFugitive().stream()
                .filter(m -> m.getId().equals(machineId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Machine non trouvée avec l'Id: " + machineId));
    }

    @Override
    public void updateEmissionFugitiveOnglet(Long id, EmissionFugitiveOngletDto emissionFugitiveOngletDto) {
        EmissionFugitiveOnglet emissionFugitiveOnglet = getEmissionFugitiveOngletById(id);

        if (emissionFugitiveOngletDto.getEstTermine() != null) {
            emissionFugitiveOnglet.setEstTermine(emissionFugitiveOngletDto.getEstTermine());
        }

        if (emissionFugitiveOngletDto.getNote() != null) {
            emissionFugitiveOnglet.setNote(emissionFugitiveOngletDto.getNote());
        }

        if (emissionFugitiveOngletDto.getMachinesEmissionFugitive() != null) {
            emissionFugitiveOngletDto.getMachinesEmissionFugitive().clear();
            for (MachineEmissionFugitiveDto machineDto : emissionFugitiveOngletDto.getMachinesEmissionFugitive()) {
                emissionFugitiveOnglet.ajouterMachineViaDto(machineDto);
            }
        }

        emissionFugitiveOngletRepository.save(emissionFugitiveOnglet);
    }

    @Override
    public void ajouterMachine(Long id, MachineEmissionFugitiveDto machineEmissionFugitiveDto) {
        EmissionFugitiveOnglet emissionFugitiveOnglet = getEmissionFugitiveOngletById(id);
        if (emissionFugitiveOnglet != null) {
            emissionFugitiveOnglet.ajouterMachineViaDto(machineEmissionFugitiveDto);
            emissionFugitiveOngletRepository.save(emissionFugitiveOnglet);
        } else {
            throw new EntityNotFoundException("EmissionFugitiveOnglet non trouvé avec l'Id: " + id);
        }
    }


    @Override
    public void supprimerMachineFromOnglet(Long ongletId, Long machineId) {
        EmissionFugitiveOnglet ongletById = getEmissionFugitiveOngletById(ongletId);

        // Trouver la machine à supprimer
        MachineEmissionFugitive machineASupprimer = ongletById.getMachinesEmissionFugitive()
                .stream()
                .filter(v -> v.getId().equals(machineId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Machine non trouvée avec l'id : " + machineId));

        // Retirer de la liste
        ongletById.getMachinesEmissionFugitive().remove(machineASupprimer);

        // Sauvegarder l'onglet
        emissionFugitiveOngletRepository.save(ongletById);
    }

    @Override
    public void updateMachinePartiel(Long ongletId, Long machineId, MachineEmissionFugitiveDto dto) {
        EmissionFugitiveOnglet onglet = getEmissionFugitiveOngletById(ongletId);
        
        MachineEmissionFugitive machine = onglet.getMachinesEmissionFugitive().stream()
                .filter(m -> m.getId().equals(machineId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Machine non trouvée avec l'Id: " + machineId));
        

        if (dto.getDescriptionMachine() != null) {
            machine.setDescriptionMachine(dto.getDescriptionMachine());
        }
        if (dto.getTypeFluide() != null) {
            machine.setTypeFluide(dto.getTypeFluide());
        }
        if (dto.getQuantiteFluideKg() != null) {
            machine.setQuantiteFluideKg(dto.getQuantiteFluideKg());
        }
        if (dto.getTauxDeFuiteConnu() != null) {
            machine.setTauxDeFuiteConnu(dto.getTauxDeFuiteConnu());
        }
        if (dto.getTauxDeFuite() != null) {
            machine.setTauxDeFuite(dto.getTauxDeFuite());
        }
        if (dto.getTypeMachine() != null) {
            machine.setTypeMachine(dto.getTypeMachine());
        }

        emissionFugitiveOngletRepository.save(getEmissionFugitiveOngletById(ongletId)); // Hibernate met à jour via cascade
    }


}
