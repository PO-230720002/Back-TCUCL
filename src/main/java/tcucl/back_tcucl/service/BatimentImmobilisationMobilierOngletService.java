package tcucl.back_tcucl.service;

import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.BatimentExistantOuNeufConstruitDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.BatimentImmobilisationMobilierOngletDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.EntretienCourantDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.MobilierElectromenagerDto;
import tcucl.back_tcucl.entity.onglet.BatimentImmobilisationMobilierOnglet;

public interface BatimentImmobilisationMobilierOngletService {

    BatimentImmobilisationMobilierOnglet getBatimentImmobilisationMobilierOngletById(Long id);

    void updateBatimentImmobilisationMobilierOnglet(Long id, BatimentImmobilisationMobilierOngletDto batimentImmobilisationMobilierOngletDto);

    void ajouterBatiment(Long id, BatimentExistantOuNeufConstruitDto batimentExistantOuNeufConstruitDto);

    void supprimerBatiment(Long ongletId, Long idBatiment);

    void updateBatimentPartiel(Long ongletId, Long batimentId, BatimentExistantOuNeufConstruitDto batimentExistantOuNeufConstruitDto);

    void ajouterEntretienCourant(Long id, EntretienCourantDto entretienCourantDto);

    void supprimerEntretienCourant(Long ongletId, Long idEntretienCourant);

    void updateEntretienCourantPartiel(Long ongletId, Long entretienCourantId, EntretienCourantDto entretienCourantDto);

    void ajouterMobilierElectromenager(Long id, MobilierElectromenagerDto mobilierElectromenagerDto);

    void supprimerMobilierElectromenager(Long ongletId, Long idMobilierElectromenager);

    void updateMobilierElectromenagerPartiel(Long ongletId, Long mobilierElectromenagerId, MobilierElectromenagerDto mobilierElectromenagerDto);
}
