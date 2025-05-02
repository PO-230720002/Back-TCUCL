package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.BatimentExistantOuNeufConstruitDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.BatimentImmobilisationMobilierOngletDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.EntretienCourantDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.MobilierElectromenagerDto;
import tcucl.back_tcucl.entity.onglet.BatimentImmobilisationMobilierOnglet;
import tcucl.back_tcucl.entity.parametre.batiment.BatimentExistantOuNeufConstruit;
import tcucl.back_tcucl.entity.parametre.batiment.EntretienCourant;
import tcucl.back_tcucl.entity.parametre.batiment.MobilierElectromenager;

public interface BatimentImmobilisationMobilierOngletManager {

    BatimentImmobilisationMobilierOnglet getBatimentImmobilisationMobilierOngletById(Long id);

    void updateBatimentImmobilisationMobilierOnglet(Long id, BatimentImmobilisationMobilierOngletDto batimentImmobilisationMobilierOngletDto);

    BatimentExistantOuNeufConstruit getBatimentById(Long ongletId, Long batimentId);

    void ajouterBatiment(Long id, BatimentExistantOuNeufConstruitDto batimentExistantOuNeufConstruitDto);

    void supprimerBatimentFromOnglet(Long ongletId, Long batimentId);

    void updateBatimentPartiel(Long ongletId, Long batimentId, BatimentExistantOuNeufConstruitDto batimentExistantOuNeufConstruitDto);



    EntretienCourant getEntretienCourantById(Long ongletId, Long entretienCourantId);

    void ajouterEntretienCourant(Long id, EntretienCourantDto entretienCourantDto);

    void supprimerEntretienCourantFromOnglet(Long ongletId, Long entretienCourantId);

    void updateEntretienCourantPartiel(Long ongletId, Long entretienCourantId, EntretienCourantDto entretienCourantDto);


    MobilierElectromenager getMobilierElectromenagerById(Long ongletId, Long mobilierElectromenagerId);

    void ajouterMobilierElectromenager(Long id, MobilierElectromenagerDto mobilierElectromenagerDto);

    void supprimerMobilierElectromenagerFromOnglet(Long ongletId, Long mobilierElectromenagerId);

    void updateMobilierElectromenagerPartiel(Long ongletId, Long mobilierElectromenagerId, MobilierElectromenagerDto mobilierElectromenagerDto);

}
