package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.MachineEmissionFugitiveDto;
import tcucl.back_tcucl.dto.onglet.EmissionFugitiveOngletDto;
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
    public void updateEmissionFugitiveOnglet(Long id, EmissionFugitiveOngletDto emissionFugitiveOngletDto) {
        EmissionFugitiveOnglet onglet = getEmissionFugitiveOngletById(id);
        if (emissionFugitiveOngletDto.getEstTermine() != null) {
            onglet.setEstTermine(emissionFugitiveOngletDto.getEstTermine());
        }

        if (emissionFugitiveOngletDto.getNote() != null) {
            onglet.setNote(emissionFugitiveOngletDto.getNote());
        }

        if (emissionFugitiveOngletDto.getMachinesEmissionFugitive() != null) {
            for (MachineEmissionFugitiveDto machineDto : emissionFugitiveOngletDto.getMachinesEmissionFugitive()) {
                if (machineDto.getId() != null) {
                    MachineEmissionFugitive machine = onglet.getMachinesEmissionFugitive()
                            .stream()
                            .filter(m -> m.getId().equals(machineDto.getId()))
                            .findFirst()
                            .orElseThrow(() -> new EntityNotFoundException("Machine with ID " + machineDto.getId() + " not found"));

                    if (machineDto.getNomMachine() != null) {
                        machine.setNomMachine(machineDto.getNomMachine());
                    }
                    if (machineDto.getDescriptionMachine() != null) {
                        machine.setDescriptionMachine(machineDto.getDescriptionMachine());
                    }
                    if (machineDto.getTypeFluide() != null) {
                        machine.setTypeFluide(machineDto.getTypeFluide());
                    }
                    if (machineDto.getQuantiteFluideKg() != null) {
                        machine.setQuantiteFluideKg(machineDto.getQuantiteFluideKg());
                    }
                    if (machineDto.getTauxDeFuiteConnu() != null) {
                        machine.setTauxDeFuiteConnu(machineDto.getTauxDeFuiteConnu());
                    }
                    if (machineDto.getTauxDeFuite() != null) {
                        machine.setTauxDeFuite(machineDto.getTauxDeFuite());
                    }
                    if (machineDto.getTypeMachine() != null) {
                        machine.setTypeMachine(machineDto.getTypeMachine());
                    }
                }
            }
        }

        emissionFugitiveOngletRepository.save(onglet);
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
    public void updateMachinePartiel(Long ongletId, Long machineId, MachineEmissionFugitiveDto dto) {
        MachineEmissionFugitive machine = getMachineById(ongletId, machineId);

        if (dto.getNomMachine() != null) {
            machine.setNomMachine(dto.getNomMachine());
        }
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
