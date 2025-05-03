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
import tcucl.back_tcucl.exceptionPersonnalisee.OngletNonTrouveIdException;
import tcucl.back_tcucl.manager.BatimentImmobilisationMobilierOngletManager;
import tcucl.back_tcucl.repository.onglet.BatimentImmobilisationMobilierOngletRepository;

@Component
public class BatimentImmobilisationMobilierOngletManagerImpl implements BatimentImmobilisationMobilierOngletManager {

    //todo problème dans les erreurs liste elt
    private final BatimentImmobilisationMobilierOngletRepository batimentImmobilisationMobilierOngletRepository;

    public BatimentImmobilisationMobilierOngletManagerImpl(BatimentImmobilisationMobilierOngletRepository batimentImmobilisationMobilierOngletRepository) {
        this.batimentImmobilisationMobilierOngletRepository = batimentImmobilisationMobilierOngletRepository;
    }

    @Override
    public BatimentImmobilisationMobilierOnglet getBatimentImmobilisationMobilierOngletById(Long ongletId) {
        return batimentImmobilisationMobilierOngletRepository.findById(ongletId)
                .orElseThrow(() -> new OngletNonTrouveIdException("BatimentImmobilisationMobilierOnglet", ongletId));
    }

    @Override
    public void updateBatimentImmobilisationMobilierOnglet(Long ongletId, BatimentImmobilisationMobilierOngletDto batimentImmobilisationMobilierOngletDto) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);

        if (batimentImmobilisationMobilierOngletDto.getEstTermine() != null) {
            batimentImmobilisationMobilierOnglet .setEstTermine(batimentImmobilisationMobilierOngletDto.getEstTermine());
        }

        if (batimentImmobilisationMobilierOngletDto.getNote() != null) {
            batimentImmobilisationMobilierOnglet .setNote(batimentImmobilisationMobilierOngletDto.getNote());
        }

        if (batimentImmobilisationMobilierOngletDto.getBatimentsExistantOuNeufConstruits() != null) {
            batimentImmobilisationMobilierOngletDto.getBatimentsExistantOuNeufConstruits().clear();
            for (BatimentExistantOuNeufConstruitDto batimentDto : batimentImmobilisationMobilierOngletDto.getBatimentsExistantOuNeufConstruits()) {
                batimentImmobilisationMobilierOnglet .ajouterBatimentViaDto(batimentDto);
            }
        }

        if (batimentImmobilisationMobilierOngletDto.getEntretiensCourants() != null) {
            batimentImmobilisationMobilierOngletDto.getEntretiensCourants().clear();
            for (EntretienCourantDto entretienCourantDto : batimentImmobilisationMobilierOngletDto.getEntretiensCourants()) {
                batimentImmobilisationMobilierOnglet .ajouterEntretienCourantViaDto(entretienCourantDto);
            }
        }

        if (batimentImmobilisationMobilierOngletDto.getMobiliersElectromenagers() != null) {
            batimentImmobilisationMobilierOngletDto.getMobiliersElectromenagers().clear();
            for (MobilierElectromenagerDto mobilierElectromenagerDto : batimentImmobilisationMobilierOngletDto.getMobiliersElectromenagers()) {
                batimentImmobilisationMobilierOnglet .ajouterMobilierElectromenagerViaDto(mobilierElectromenagerDto);
            }
        }

        batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet);
    }

    @Override
    public BatimentExistantOuNeufConstruit getBatimentById(Long ongletId, Long batimentId) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);
        return batimentImmobilisationMobilierOnglet .getBatimentExistantOuNeufConstruits().stream()
                .filter(m -> m.getId().equals(batimentId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Batiment non trouvée avec l'Id: " + batimentId));
    }

    @Override
    public void ajouterBatiment(Long ongletId, BatimentExistantOuNeufConstruitDto batimentExistantOuNeufConstruitDto) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);
        batimentImmobilisationMobilierOnglet.ajouterBatimentViaDto(batimentExistantOuNeufConstruitDto);
        batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet);
    }

    @Override
    public void supprimerBatimentFromOnglet(Long ongletId, Long batimentId) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);

        // Trouver la machine à supprimer
        BatimentExistantOuNeufConstruit batimentASupprimer = batimentImmobilisationMobilierOnglet .getBatimentExistantOuNeufConstruits()
                .stream()
                .filter(v -> v.getId().equals(batimentId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("batiment non trouvée avec l'id : " + batimentId));

        // Retirer de la liste
        batimentImmobilisationMobilierOnglet .getBatimentExistantOuNeufConstruits().remove(batimentASupprimer);

        // Sauvegarder l'onglet
        batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet);
    }

    @Override
    public void updateBatimentPartiel(Long ongletId, Long batimentId, BatimentExistantOuNeufConstruitDto dto) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);

        BatimentExistantOuNeufConstruit batiment = batimentImmobilisationMobilierOnglet .getBatimentExistantOuNeufConstruits().stream()
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
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);
        return batimentImmobilisationMobilierOnglet .getEntretienCourants().stream()
                .filter(m -> m.getId().equals(entretienCourantId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Batiment non trouvée avec l'Id: " + entretienCourantId));
    }

    @Override
    public void ajouterEntretienCourant(Long ongletId, EntretienCourantDto entretienCourantDto) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);
        batimentImmobilisationMobilierOnglet.ajouterEntretienCourantViaDto(entretienCourantDto);
        batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet);
    }

    @Override
    public void supprimerEntretienCourantFromOnglet(Long ongletId, Long entretienCourantId) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);

        // Trouver la machine à supprimer
        EntretienCourant entretienCourantASupprimer = batimentImmobilisationMobilierOnglet .getEntretienCourants()
                .stream()
                .filter(v -> v.getId().equals(entretienCourantId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("batiment non trouvée avec l'id : " + entretienCourantId));

        // Retirer de la liste
        batimentImmobilisationMobilierOnglet .getEntretienCourants().remove(entretienCourantASupprimer);

        // Sauvegarder l'onglet
        batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet);
    }

    @Override
    public void updateEntretienCourantPartiel(Long ongletId, Long entretienCourantId, EntretienCourantDto dto) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);

        EntretienCourant entretienCourant = batimentImmobilisationMobilierOnglet .getEntretienCourants().stream()
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
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);
        return batimentImmobilisationMobilierOnglet .getMobilierElectromenagers().stream()
                .filter(m -> m.getId().equals(mobilierElectromenagerId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Batiment non trouvée avec l'Id: " + mobilierElectromenagerId));

    }

    @Override
    public void ajouterMobilierElectromenager(Long ongletId, MobilierElectromenagerDto mobilierElectromenagerDto) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);
        batimentImmobilisationMobilierOnglet.ajouterMobilierElectromenagerViaDto(mobilierElectromenagerDto);
        batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet);
    }

    @Override
    public void supprimerMobilierElectromenagerFromOnglet(Long ongletId, Long mobilierElectromenagerId) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);

        // Trouver la machine à supprimer
        MobilierElectromenager mobilierElectromenagerASupprimer = batimentImmobilisationMobilierOnglet .getMobilierElectromenagers()
                .stream()
                .filter(v -> v.getId().equals(mobilierElectromenagerId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("batiment non trouvée avec l'id : " + mobilierElectromenagerId));

        // Retirer de la liste
        batimentImmobilisationMobilierOnglet .getMobilierElectromenagers().remove(mobilierElectromenagerASupprimer);

        // Sauvegarder l'onglet
        batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet);

    }

    @Override
    public void updateMobilierElectromenagerPartiel(Long ongletId, Long mobilierElectromenagerId, MobilierElectromenagerDto dto) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);

        MobilierElectromenager mobilierElectromenager = batimentImmobilisationMobilierOnglet .getMobilierElectromenagers().stream()
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
