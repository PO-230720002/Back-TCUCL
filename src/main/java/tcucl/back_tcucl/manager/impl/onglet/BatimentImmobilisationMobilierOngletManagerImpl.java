package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.BatimentExistantOuNeufConstruitDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.BatimentImmobilisationMobilierOngletDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.EntretienCourantDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.MobilierElectromenagerDto;
import tcucl.back_tcucl.entity.onglet.batiment.BatimentImmobilisationMobilierOnglet;
import tcucl.back_tcucl.entity.onglet.batiment.BatimentExistantOuNeufConstruit;
import tcucl.back_tcucl.entity.onglet.batiment.EntretienCourant;
import tcucl.back_tcucl.entity.onglet.batiment.MobilierElectromenager;
import tcucl.back_tcucl.entity.onglet.batiment.enums.EnumBatiment_Mobilier;
import tcucl.back_tcucl.entity.onglet.parkingVoirie.ParkingVoirieOnglet;
import tcucl.back_tcucl.exceptionPersonnalisee.ElementNontrouveException;
import tcucl.back_tcucl.exceptionPersonnalisee.OngletNonTrouveIdException;
import tcucl.back_tcucl.exceptionPersonnalisee.ValidationCustomException;
import tcucl.back_tcucl.manager.BatimentImmobilisationMobilierOngletManager;
import tcucl.back_tcucl.repository.onglet.BatimentImmobilisationMobilierOngletRepository;

import java.time.LocalDate;
import java.util.Set;

@Component
public class BatimentImmobilisationMobilierOngletManagerImpl implements BatimentImmobilisationMobilierOngletManager {

    @Autowired
    private Validator validator;

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
            batimentImmobilisationMobilierOnglet.setEstTermine(batimentImmobilisationMobilierOngletDto.getEstTermine());
        }

        if (batimentImmobilisationMobilierOngletDto.getNote() != null) {
            batimentImmobilisationMobilierOnglet.setNote(batimentImmobilisationMobilierOngletDto.getNote());
        }

        if (batimentImmobilisationMobilierOngletDto.getBatimentsExistantOuNeufConstruits() != null) {
            batimentImmobilisationMobilierOnglet.getBatimentExistantOuNeufConstruits().clear();
            for (BatimentExistantOuNeufConstruitDto batimentDto : batimentImmobilisationMobilierOngletDto.getBatimentsExistantOuNeufConstruits()) {
                batimentImmobilisationMobilierOnglet.ajouterBatimentViaDto(batimentDto);
            }
        }

        if (batimentImmobilisationMobilierOngletDto.getEntretiensCourants() != null) {
            batimentImmobilisationMobilierOnglet.getEntretienCourants().clear();
            for (EntretienCourantDto entretienCourantDto : batimentImmobilisationMobilierOngletDto.getEntretiensCourants()) {
                batimentImmobilisationMobilierOnglet.ajouterEntretienCourantViaDto(entretienCourantDto);
            }
        }

        if (batimentImmobilisationMobilierOngletDto.getMobiliersElectromenagers() != null) {
            batimentImmobilisationMobilierOnglet.getMobilierElectromenagers().clear();
            for (MobilierElectromenagerDto mobilierElectromenagerDto : batimentImmobilisationMobilierOngletDto.getMobiliersElectromenagers()) {
                batimentImmobilisationMobilierOnglet.ajouterMobilierElectromenagerViaDto(mobilierElectromenagerDto);
            }
        }

        
        Set<ConstraintViolation<BatimentImmobilisationMobilierOnglet>> violations = validator.validate(batimentImmobilisationMobilierOnglet);
        if(!violations.isEmpty()) {
            throw new ValidationCustomException(violations);
        }
        batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet);
    }

    @Override
    public BatimentExistantOuNeufConstruit getBatimentById(Long ongletId, Long batimentId) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);
        return batimentImmobilisationMobilierOnglet.getBatimentExistantOuNeufConstruits().stream()
                .filter(m -> m.getId().equals(batimentId))
                .findFirst()
                .orElseThrow(() -> new ElementNontrouveException("BatimentExistantOuNeufConstruit", batimentId));
    }

    @Override
    public void ajouterBatiment(Long ongletId, BatimentExistantOuNeufConstruitDto batimentExistantOuNeufConstruitDto) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);
        batimentImmobilisationMobilierOnglet.ajouterBatimentViaDto(batimentExistantOuNeufConstruitDto);
        Set<ConstraintViolation<BatimentImmobilisationMobilierOnglet>> violations = validator.validate(batimentImmobilisationMobilierOnglet);
        if(!violations.isEmpty()) {
            throw new ValidationCustomException(violations);
        }
        batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet);
    }

    @Override
    public void supprimerBatimentFromOnglet(Long ongletId, Long batimentId) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);

        // Trouver la machine à supprimer
        BatimentExistantOuNeufConstruit batimentASupprimer = batimentImmobilisationMobilierOnglet.getBatimentExistantOuNeufConstruits()
                .stream()
                .filter(v -> v.getId().equals(batimentId))
                .findFirst()
                .orElseThrow(() -> new ElementNontrouveException("BatimentExistantOuNeufConstruit", batimentId));

        // Retirer de la liste
        batimentImmobilisationMobilierOnglet.getBatimentExistantOuNeufConstruits().remove(batimentASupprimer);

        // Sauvegarder l'onglet
        Set<ConstraintViolation<BatimentImmobilisationMobilierOnglet>> violations = validator.validate(batimentImmobilisationMobilierOnglet);
        if(!violations.isEmpty()) {
            throw new ValidationCustomException(violations);
        }
        batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet);
    }

    @Override
    public void updateBatimentPartiel(Long ongletId, Long batimentId, BatimentExistantOuNeufConstruitDto dto) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);

        BatimentExistantOuNeufConstruit batiment = batimentImmobilisationMobilierOnglet.getBatimentExistantOuNeufConstruits().stream()
                .filter(m -> m.getId().equals(batimentId))
                .findFirst()
                .orElseThrow(() -> new ElementNontrouveException("BatimentExistantOuNeufConstruit", batimentId));


        if (dto.getNom_ou_adresse() != null) {
            batiment.setNom_ou_adresse(dto.getNom_ou_adresse());
        }
        if (dto.getDateConstruction() != null) {
            batiment.setDateConstruction(dto.getDateConstruction());
        }
        if (dto.getDateDerniereGrosseRenovation() != null) {
            batiment.setDateDerniereGrosseRenovation(dto.getDateDerniereGrosseRenovation());
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

        Set<ConstraintViolation<BatimentImmobilisationMobilierOnglet>> violations = validator.validate(batimentImmobilisationMobilierOnglet);
        if(!violations.isEmpty()) {
            throw new ValidationCustomException(violations);
        }
        batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet); // Hibernate met à jour via cascade
    }

    @Override
    public EntretienCourant getEntretienCourantById(Long ongletId, Long entretienCourantId) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);
        return batimentImmobilisationMobilierOnglet.getEntretienCourants().stream()
                .filter(m -> m.getId().equals(entretienCourantId))
                .findFirst()
                .orElseThrow(() -> new ElementNontrouveException("EntretienCourant", entretienCourantId));

    }

    @Override
    public void ajouterEntretienCourant(Long ongletId, EntretienCourantDto entretienCourantDto) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);
        batimentImmobilisationMobilierOnglet.ajouterEntretienCourantViaDto(entretienCourantDto);
        Set<ConstraintViolation<BatimentImmobilisationMobilierOnglet>> violations = validator.validate(batimentImmobilisationMobilierOnglet);
        if(!violations.isEmpty()) {
            throw new ValidationCustomException(violations);
        }
        batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet);
    }

    @Override
    public void supprimerEntretienCourantFromOnglet(Long ongletId, Long entretienCourantId) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);

        // Trouver la machine à supprimer
        EntretienCourant entretienCourantASupprimer = batimentImmobilisationMobilierOnglet.getEntretienCourants()
                .stream()
                .filter(v -> v.getId().equals(entretienCourantId))
                .findFirst()
                .orElseThrow(() -> new ElementNontrouveException("EntretienCourant", entretienCourantId));

        // Retirer de la liste
        batimentImmobilisationMobilierOnglet.getEntretienCourants().remove(entretienCourantASupprimer);

        // Sauvegarder l'onglet
        Set<ConstraintViolation<BatimentImmobilisationMobilierOnglet>> violations = validator.validate(batimentImmobilisationMobilierOnglet);
        if(!violations.isEmpty()) {
            throw new ValidationCustomException(violations);
        }
        batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet);
    }

    @Override
    public void updateEntretienCourantPartiel(Long ongletId, Long entretienCourantId, EntretienCourantDto dto) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);

        EntretienCourant entretienCourant = batimentImmobilisationMobilierOnglet.getEntretienCourants().stream()
                .filter(m -> m.getId().equals(entretienCourantId))
                .findFirst()
                .orElseThrow(() -> new ElementNontrouveException("EntretienCourant", entretienCourantId));


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

        Set<ConstraintViolation<BatimentImmobilisationMobilierOnglet>> violations = validator.validate(batimentImmobilisationMobilierOnglet);
        if(!violations.isEmpty()) {
            throw new ValidationCustomException(violations);
        }
        batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet); // Hibernate met à jour via cascade

    }

    @Override
    public MobilierElectromenager getMobilierElectromenagerById(Long ongletId, Long mobilierElectromenagerId) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);
        return batimentImmobilisationMobilierOnglet.getMobilierElectromenagers().stream()
                .filter(m -> m.getId().equals(mobilierElectromenagerId))
                .findFirst()
                .orElseThrow(() -> new ElementNontrouveException("MobilierElectromenager", mobilierElectromenagerId));


    }

    @Override
    public void ajouterMobilierElectromenager(Long ongletId, MobilierElectromenagerDto mobilierElectromenagerDto) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);
        batimentImmobilisationMobilierOnglet.ajouterMobilierElectromenagerViaDto(mobilierElectromenagerDto);
        Set<ConstraintViolation<BatimentImmobilisationMobilierOnglet>> violations = validator.validate(batimentImmobilisationMobilierOnglet);
        if(!violations.isEmpty()) {
            throw new ValidationCustomException(violations);
        }
        batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet);
    }

    @Override
    public void supprimerMobilierElectromenagerFromOnglet(Long ongletId, Long mobilierElectromenagerId) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);

        // Trouver la machine à supprimer
        MobilierElectromenager mobilierElectromenagerASupprimer = batimentImmobilisationMobilierOnglet.getMobilierElectromenagers()
                .stream()
                .filter(v -> v.getId().equals(mobilierElectromenagerId))
                .findFirst()
                .orElseThrow(() -> new ElementNontrouveException("MobilierElectromenager", mobilierElectromenagerId));


        // Retirer de la liste
        batimentImmobilisationMobilierOnglet.getMobilierElectromenagers().remove(mobilierElectromenagerASupprimer);

        // Sauvegarder l'onglet
        Set<ConstraintViolation<BatimentImmobilisationMobilierOnglet>> violations = validator.validate(batimentImmobilisationMobilierOnglet);
        if(!violations.isEmpty()) {
            throw new ValidationCustomException(violations);
        }
        batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet);

    }

    @Override
    public void updateMobilierElectromenagerPartiel(Long ongletId, Long mobilierElectromenagerId, MobilierElectromenagerDto mobilierElectromenagerDto) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = getBatimentImmobilisationMobilierOngletById(ongletId);

        MobilierElectromenager mobilierElectromenager = batimentImmobilisationMobilierOnglet.getMobilierElectromenagers().stream()
                .filter(m -> m.getId().equals(mobilierElectromenagerId))
                .findFirst()
                .orElseThrow(() -> new ElementNontrouveException("MobilierElectromenager", mobilierElectromenagerId));


        if (mobilierElectromenagerDto.getMobilier() != null) {
            mobilierElectromenager.setMobilier(mobilierElectromenagerDto.getMobilier());
        }
        if (mobilierElectromenagerDto.getDateAjout() != null) {
            mobilierElectromenager.setDateAjout(mobilierElectromenagerDto.getDateAjout());
        }
        if (mobilierElectromenagerDto.getQuantite() != null) {
            mobilierElectromenager.setQuantite(mobilierElectromenagerDto.getQuantite());
        }
        if (mobilierElectromenagerDto.getPoidsDuProduit() != null) {
            mobilierElectromenager.setPoidsDuProduit(mobilierElectromenagerDto.getPoidsDuProduit());
        }
        if (mobilierElectromenagerDto.getDureeAmortissement() != null) {
            mobilierElectromenager.setDureeAmortissement(mobilierElectromenagerDto.getDureeAmortissement());
        }
        if (mobilierElectromenagerDto.getEmissionGesPrecisesConnues() != null) {
            mobilierElectromenager.setEmissionGesPrecisesConnues(mobilierElectromenagerDto.getEmissionGesPrecisesConnues());
        }
        if (mobilierElectromenagerDto.getEmissionsGesReelleskgCO2() != null) {
            mobilierElectromenager.setEmissionsGesReelleskgCO2(mobilierElectromenagerDto.getEmissionsGesReelleskgCO2());
        }

        Set<ConstraintViolation<BatimentImmobilisationMobilierOnglet>> violations = validator.validate(batimentImmobilisationMobilierOnglet);
        if(!violations.isEmpty()) {
            throw new ValidationCustomException(violations);
        }
        batimentImmobilisationMobilierOngletRepository.save(batimentImmobilisationMobilierOnglet);

    }


}
