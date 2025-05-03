package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.BatimentExistantOuNeufConstruitDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.BatimentImmobilisationMobilierOngletDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.EntretienCourantDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.MobilierElectromenagerDto;
import tcucl.back_tcucl.entity.onglet.batiment.BatimentImmobilisationMobilierOnglet;
import tcucl.back_tcucl.entity.onglet.batiment.BatimentExistantOuNeufConstruit;
import tcucl.back_tcucl.entity.onglet.batiment.EntretienCourant;
import tcucl.back_tcucl.entity.onglet.batiment.MobilierElectromenager;
import tcucl.back_tcucl.manager.BatimentImmobilisationMobilierOngletManager;
import tcucl.back_tcucl.repository.onglet.BatimentImmobilisationMobilierOngletRepository;

@Component
public class BatimentImmobilisationMobilierOngletManagerImpl implements BatimentImmobilisationMobilierOngletManager {

    private final BatimentImmobilisationMobilierOngletRepository batimentImmobilisationMobilierOngletRepository;

    public BatimentImmobilisationMobilierOngletManagerImpl(BatimentImmobilisationMobilierOngletRepository batimentImmobilisationMobilierOngletRepository) {
        this.batimentImmobilisationMobilierOngletRepository = batimentImmobilisationMobilierOngletRepository;
    }

    @Override
    public BatimentImmobilisationMobilierOnglet getBatimentImmobilisationMobilierOngletById(Long ongletId) {
        return batimentImmobilisationMobilierOngletRepository.findById(ongletId)
                .orElseThrow(() -> new EntityNotFoundException("BatimentImmobilisationMobilierOnglet non trouvé avec l'Id : " + ongletId));
    }

    @Override
    public void updateBatimentImmobilisationMobilierOnglet(Long ongletId, BatimentImmobilisationMobilierOngletDto batimentImmobilisationMobilierOngletDto) {
        BatimentImmobilisationMobilierOnglet onglet = getBatimentImmobilisationMobilierOngletById(ongletId);

        if (batimentImmobilisationMobilierOngletDto.getEstTermine() != null) {
            onglet.setEstTermine(batimentImmobilisationMobilierOngletDto.getEstTermine());
        }

        if (batimentImmobilisationMobilierOngletDto.getNote() != null) {
            onglet.setNote(batimentImmobilisationMobilierOngletDto.getNote());
        }

        if (batimentImmobilisationMobilierOngletDto.getBatimentsExistantOuNeufConstruits() != null) {
            batimentImmobilisationMobilierOngletDto.getBatimentsExistantOuNeufConstruits().clear();
            for (BatimentExistantOuNeufConstruitDto batimentDto : batimentImmobilisationMobilierOngletDto.getBatimentsExistantOuNeufConstruits()) {
                onglet.ajouterBatimentViaDto(batimentDto);
            }
        }

        if (batimentImmobilisationMobilierOngletDto.getEntretiensCourants() != null) {
            batimentImmobilisationMobilierOngletDto.getEntretiensCourants().clear();
            for (EntretienCourantDto entretienCourantDto : batimentImmobilisationMobilierOngletDto.getEntretiensCourants()) {
                onglet.ajouterEntretienCourantViaDto(entretienCourantDto);
            }
        }

        if (batimentImmobilisationMobilierOngletDto.getMobiliersElectromenagers() != null) {
            batimentImmobilisationMobilierOngletDto.getMobiliersElectromenagers().clear();
            for (MobilierElectromenagerDto mobilierElectromenagerDto : batimentImmobilisationMobilierOngletDto.getMobiliersElectromenagers()) {
                onglet.ajouterMobilierElectromenagerViaDto(mobilierElectromenagerDto);
            }
        }

        batimentImmobilisationMobilierOngletRepository.save(onglet);
    }

    @Override
    public BatimentExistantOuNeufConstruit getBatimentById(Long ongletId, Long batimentId) {
        BatimentImmobilisationMobilierOnglet onglet = getBatimentImmobilisationMobilierOngletById(ongletId);
        return onglet.getBatimentExistantOuNeufConstruits().stream()
                .filter(m -> m.getId().equals(batimentId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Batiment non trouvée avec l'Id: " + batimentId));
    }

    @Override
    public void ajouterBatiment(Long ongletId, BatimentExistantOuNeufConstruitDto batimentExistantOuNeufConstruitDto) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);
        if (batimentImmobilisationMobilierOnglet != null) {
            batimentImmobilisationMobilierOnglet.ajouterBatimentViaDto(batimentExistantOuNeufConstruitDto);
            batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet);
        } else {
            throw new EntityNotFoundException("BatimentImmobilisationMobilierOnglet non trouvé avec l'Id: " + ongletId);
        }
    }

    @Override
    public void supprimerBatimentFromOnglet(Long ongletId, Long batimentId) {
        BatimentImmobilisationMobilierOnglet ongletById = getBatimentImmobilisationMobilierOngletById(ongletId);

        // Trouver la machine à supprimer
        BatimentExistantOuNeufConstruit batimentASupprimer = ongletById.getBatimentExistantOuNeufConstruits()
                .stream()
                .filter(v -> v.getId().equals(batimentId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("batiment non trouvée avec l'id : " + batimentId));

        // Retirer de la liste
        ongletById.getBatimentExistantOuNeufConstruits().remove(batimentASupprimer);

        // Sauvegarder l'onglet
        batimentImmobilisationMobilierOngletRepository.save(ongletById);
    }

    @Override
    public void updateBatimentPartiel(Long ongletId, Long batimentId, BatimentExistantOuNeufConstruitDto dto) {
        BatimentImmobilisationMobilierOnglet onglet = getBatimentImmobilisationMobilierOngletById(ongletId);

        BatimentExistantOuNeufConstruit batiment = onglet.getBatimentExistantOuNeufConstruits().stream()
                .filter(m -> m.getId().equals(batimentId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Machine non trouvée avec l'Id: " + batimentId));


        if (dto.getNom_ou_adresse() != null) {
            batiment.setNom_ou_adresse(dto.getNom_ou_adresse());
        }
        if (dto.getDateConstruction() != null) {
            batiment.setDateConstruction(dto.getDateConstruction());
        }
        if (dto.getDateDerniereGrosseRenovation() != null) {
            batiment.setDateDerniereGrosseRenovation(dto.getDateDerniereGrosseRenovation());
        }
        if (dto.getACompleter() != null) {
            batiment.setACompleter(dto.getACompleter());
        }
        if (dto.getAcvBatimentRealisee() != null) {
            batiment.setAcvBatimentRealisee(dto.getAcvBatimentRealisee());
        }
        if (dto.getEmissionsGesReellesTCO2() != null) {
            batiment.setEmissionsGesReellesTCO2(dto.getEmissionsGesReellesTCO2());
        }
        if (dto.getTypeBatiment() != null) {
            batiment.setTypeBatiment(dto.getTypeBatiment());
        }
        if (dto.getSurfaceEnM2() != null) {
            batiment.setSurfaceEnM2(dto.getSurfaceEnM2());
        }
        if (dto.getTypeStructure() != null) {
            batiment.setTypeStructure(dto.getTypeStructure());
        }

        batimentImmobilisationMobilierOngletRepository.save(getBatimentImmobilisationMobilierOngletById(ongletId)); // Hibernate met à jour via cascade
    }

    @Override
    public EntretienCourant getEntretienCourantById(Long ongletId, Long entretienCourantId) {
        BatimentImmobilisationMobilierOnglet onglet = getBatimentImmobilisationMobilierOngletById(ongletId);
        return onglet.getEntretienCourants().stream()
                .filter(m -> m.getId().equals(entretienCourantId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Batiment non trouvée avec l'Id: " + entretienCourantId));
    }

    @Override
    public void ajouterEntretienCourant(Long ongletId, EntretienCourantDto entretienCourantDto) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);
        if (batimentImmobilisationMobilierOnglet != null) {
            batimentImmobilisationMobilierOnglet.ajouterEntretienCourantViaDto(entretienCourantDto);
            batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet);
        } else {
            throw new EntityNotFoundException("BatimentImmobilisationMobilierOnglet non trouvé avec l'Id: " + ongletId);
        }
    }

    @Override
    public void supprimerEntretienCourantFromOnglet(Long ongletId, Long entretienCourantId) {
        BatimentImmobilisationMobilierOnglet ongletById = getBatimentImmobilisationMobilierOngletById(ongletId);

        // Trouver la machine à supprimer
        EntretienCourant entretienCourantASupprimer = ongletById.getEntretienCourants()
                .stream()
                .filter(v -> v.getId().equals(entretienCourantId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("batiment non trouvée avec l'id : " + entretienCourantId));

        // Retirer de la liste
        ongletById.getEntretienCourants().remove(entretienCourantASupprimer);

        // Sauvegarder l'onglet
        batimentImmobilisationMobilierOngletRepository.save(ongletById);
    }

    @Override
    public void updateEntretienCourantPartiel(Long ongletId, Long entretienCourantId, EntretienCourantDto dto) {
        BatimentImmobilisationMobilierOnglet onglet = getBatimentImmobilisationMobilierOngletById(ongletId);

        EntretienCourant entretienCourant = onglet.getEntretienCourants().stream()
                .filter(m -> m.getId().equals(entretienCourantId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Machine non trouvée avec l'Id: " + entretienCourantId));


        if (dto.getDateAjout() != null) {
            entretienCourant.setDateAjout(dto.getDateAjout());
        }
        if (dto.getNom_adresse() != null) {
            entretienCourant.setNom_adresse(dto.getNom_adresse());
        }
        if (dto.getDateTravaux() != null) {
            entretienCourant.setDateTravaux(dto.getDateTravaux());
        }
        if (dto.getAcvRenovationRealisee() != null) {
            entretienCourant.setAcvRenovationRealisee(dto.getAcvRenovationRealisee());
        }
        if (dto.getEmissionsGesReellesTCO2() != null) {
            entretienCourant.setEmissionsGesReellesTCO2(dto.getEmissionsGesReellesTCO2());
        }
        if (dto.getSurfaceConcernee() != null) {
            entretienCourant.setSurfaceConcernee(dto.getSurfaceConcernee());
        }
        if (dto.getDureeAmortissement() != null) {
            entretienCourant.setDureeAmortissement(dto.getDureeAmortissement());
        }
        if (dto.getTypeTravaux() != null) {
            entretienCourant.setTypeTravaux(dto.getTypeTravaux());
        }
        if (dto.getTypeBatiment() != null) {
            entretienCourant.setTypeBatiment(dto.getTypeBatiment());
        }

        batimentImmobilisationMobilierOngletRepository.save(getBatimentImmobilisationMobilierOngletById(ongletId)); // Hibernate met à jour via cascade

    }

    @Override
    public MobilierElectromenager getMobilierElectromenagerById(Long ongletId, Long mobilierElectromenagerId) {
        BatimentImmobilisationMobilierOnglet onglet = getBatimentImmobilisationMobilierOngletById(ongletId);
        return onglet.getMobilierElectromenagers().stream()
                .filter(m -> m.getId().equals(mobilierElectromenagerId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Batiment non trouvée avec l'Id: " + mobilierElectromenagerId));

    }

    @Override
    public void ajouterMobilierElectromenager(Long ongletId, MobilierElectromenagerDto mobilierElectromenagerDto) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);
        if (batimentImmobilisationMobilierOnglet != null) {
            batimentImmobilisationMobilierOnglet.ajouterMobilierElectromenagerViaDto(mobilierElectromenagerDto);
            batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet);
        } else {
            throw new EntityNotFoundException("BatimentImmobilisationMobilierOnglet non trouvé avec l'Id: " + ongletId);
        }
    }

    @Override
    public void supprimerMobilierElectromenagerFromOnglet(Long ongletId, Long mobilierElectromenagerId) {
        BatimentImmobilisationMobilierOnglet ongletById = getBatimentImmobilisationMobilierOngletById(ongletId);

        // Trouver la machine à supprimer
        MobilierElectromenager mobilierElectromenagerASupprimer = ongletById.getMobilierElectromenagers()
                .stream()
                .filter(v -> v.getId().equals(mobilierElectromenagerId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("batiment non trouvée avec l'id : " + mobilierElectromenagerId));

        // Retirer de la liste
        ongletById.getMobilierElectromenagers().remove(mobilierElectromenagerASupprimer);

        // Sauvegarder l'onglet
        batimentImmobilisationMobilierOngletRepository.save(ongletById);

    }

    @Override
    public void updateMobilierElectromenagerPartiel(Long ongletId, Long mobilierElectromenagerId, MobilierElectromenagerDto dto) {
        BatimentImmobilisationMobilierOnglet onglet = getBatimentImmobilisationMobilierOngletById(ongletId);

        MobilierElectromenager mobilierElectromenager = onglet.getMobilierElectromenagers().stream()
                .filter(m -> m.getId().equals(mobilierElectromenagerId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Machine non trouvée avec l'Id: " + mobilierElectromenagerId));


        if (dto.getDateAjout() != null) {
            mobilierElectromenager.setDateAjout(dto.getDateAjout());
        }
        if (dto.getQuantite() != null) {
            mobilierElectromenager.setQuantite(dto.getQuantite());
        }
        if (dto.getPoidsDuProduit() != null) {
            mobilierElectromenager.setPoidsDuProduit(dto.getPoidsDuProduit());
        }
        if (dto.getDureeAmortissement() != null) {
            mobilierElectromenager.setDureeAmortissement(dto.getDureeAmortissement());
        }
        if (dto.getEmissionGesPrecisesConnues() != null) {
            mobilierElectromenager.setEmissionGesPrecisesConnues(dto.getEmissionGesPrecisesConnues());
        }
        if (dto.getEmissionsGesReelleskgCO2() != null) {
            mobilierElectromenager.setEmissionsGesReelleskgCO2(dto.getEmissionsGesReelleskgCO2());
        }

        batimentImmobilisationMobilierOngletRepository.save(getBatimentImmobilisationMobilierOngletById(ongletId)); // Hibernate met à jour via cascade

    }


}
