package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.BatimentExistantOuNeufConstruitDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.BatimentImmobilisationMobilierOngletDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.EntretienCourantDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.MobilierElectromenagerDto;
import tcucl.back_tcucl.entity.onglet.batiment.BatimentImmobilisationMobilierOnglet;
import tcucl.back_tcucl.manager.BatimentImmobilisationMobilierOngletManager;
import tcucl.back_tcucl.service.BatimentImmobilisationMobilierOngletService;
@Service
public class BatimentImmobilisationMobilierOngletServiceImpl implements BatimentImmobilisationMobilierOngletService {
    
    private final BatimentImmobilisationMobilierOngletManager batimentImmobilisationMobilierOngletManager;

    public BatimentImmobilisationMobilierOngletServiceImpl(BatimentImmobilisationMobilierOngletManager batimentImmobilisationMobilierOngletManager) {
        this.batimentImmobilisationMobilierOngletManager = batimentImmobilisationMobilierOngletManager;
    }
    @Override
    public BatimentImmobilisationMobilierOnglet getBatimentImmobilisationMobilierOngletById(Long ongletId) {
        return batimentImmobilisationMobilierOngletManager.getBatimentImmobilisationMobilierOngletById(ongletId);

    }

    @Override
    public void updateBatimentImmobilisationMobilierOnglet(Long ongletId, BatimentImmobilisationMobilierOngletDto batimentImmobilisationMobilierOngletDto) {
        batimentImmobilisationMobilierOngletManager.updateBatimentImmobilisationMobilierOnglet(ongletId, batimentImmobilisationMobilierOngletDto);

    }

    @Override
    public void ajouterBatiment(Long ongletId, BatimentExistantOuNeufConstruitDto batimentExistantOuNeufConstruitDto) {
        batimentImmobilisationMobilierOngletManager.ajouterBatiment(ongletId, batimentExistantOuNeufConstruitDto);
    }

    @Override
    public void supprimerBatiment(Long ongletId, Long batimentId) {
        batimentImmobilisationMobilierOngletManager.supprimerBatimentFromOnglet(ongletId, batimentId);
    }

    @Override
    public void updateBatimentPartiel(Long ongletId, Long batimentId, BatimentExistantOuNeufConstruitDto batimentExistantOuNeufConstruitDto) {
        batimentImmobilisationMobilierOngletManager.updateBatimentPartiel(ongletId, batimentId, batimentExistantOuNeufConstruitDto);

    }

    @Override
    public void ajouterEntretienCourant(Long ongletId, EntretienCourantDto entretienCourantDto) {
        batimentImmobilisationMobilierOngletManager.ajouterEntretienCourant(ongletId, entretienCourantDto);

    }

    @Override
    public void supprimerEntretienCourant(Long ongletId, Long entretienCourantId) {
        batimentImmobilisationMobilierOngletManager.supprimerEntretienCourantFromOnglet(ongletId, entretienCourantId);

    }

    @Override
    public void updateEntretienCourantPartiel(Long ongletId, Long entretienCourantId, EntretienCourantDto entretienCourantDto) {
        batimentImmobilisationMobilierOngletManager.updateEntretienCourantPartiel(ongletId, entretienCourantId, entretienCourantDto);

    }

    @Override
    public void ajouterMobilierElectromenager(Long ongletId, MobilierElectromenagerDto mobilierElectromenagerDto) {
        batimentImmobilisationMobilierOngletManager.ajouterMobilierElectromenager(ongletId, mobilierElectromenagerDto);

    }

    @Override
    public void supprimerMobilierElectromenager(Long ongletId, Long mobilierElectromenagerId) {
        batimentImmobilisationMobilierOngletManager.supprimerMobilierElectromenagerFromOnglet(ongletId, mobilierElectromenagerId);

    }

    @Override
    public void updateMobilierElectromenagerPartiel(Long ongletId, Long mobilierElectromenagerId, MobilierElectromenagerDto mobilierElectromenagerDto) {
        batimentImmobilisationMobilierOngletManager.updateMobilierElectromenagerPartiel(ongletId, mobilierElectromenagerId, mobilierElectromenagerDto);

    }
}
