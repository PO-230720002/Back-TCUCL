package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.BatimentExistantOuNeufConstruitDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.BatimentImmobilisationMobilierOngletDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.EntretienCourantDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.MobilierElectromenagerDto;
import tcucl.back_tcucl.entity.onglet.BatimentImmobilisationMobilierOnglet;
import tcucl.back_tcucl.manager.BatimentImmobilisationMobilierOngletManager;
import tcucl.back_tcucl.service.BatimentImmobilisationMobilierOngletService;
@Service
public class BatimentImmobilisationMobilierOngletServiceImpl implements BatimentImmobilisationMobilierOngletService {
    
    private final BatimentImmobilisationMobilierOngletManager batimentImmobilisationMobilierOngletManager;

    public BatimentImmobilisationMobilierOngletServiceImpl(BatimentImmobilisationMobilierOngletManager batimentImmobilisationMobilierOngletManager) {
        this.batimentImmobilisationMobilierOngletManager = batimentImmobilisationMobilierOngletManager;
    }
    @Override
    public BatimentImmobilisationMobilierOnglet getBatimentImmobilisationMobilierOngletById(Long id) {
        return batimentImmobilisationMobilierOngletManager.getBatimentImmobilisationMobilierOngletById(id);

    }

    @Override
    public void updateBatimentImmobilisationMobilierOnglet(Long id, BatimentImmobilisationMobilierOngletDto batimentImmobilisationMobilierOngletDto) {
        batimentImmobilisationMobilierOngletManager.updateBatimentImmobilisationMobilierOnglet(id, batimentImmobilisationMobilierOngletDto);

    }

    @Override
    public void ajouterBatiment(Long id, BatimentExistantOuNeufConstruitDto batimentExistantOuNeufConstruitDto) {
        batimentImmobilisationMobilierOngletManager.ajouterBatiment(id, batimentExistantOuNeufConstruitDto);
    }

    @Override
    public void supprimerBatiment(Long ongletId, Long idBatiment) {
        batimentImmobilisationMobilierOngletManager.supprimerBatimentFromOnglet(ongletId, idBatiment);
    }

    @Override
    public void updateBatimentPartiel(Long ongletId, Long batimentId, BatimentExistantOuNeufConstruitDto batimentExistantOuNeufConstruitDto) {
        batimentImmobilisationMobilierOngletManager.updateBatimentPartiel(ongletId, batimentId, batimentExistantOuNeufConstruitDto);

    }

    @Override
    public void ajouterEntretienCourant(Long id, EntretienCourantDto entretienCourantDto) {
        batimentImmobilisationMobilierOngletManager.ajouterEntretienCourant(id, entretienCourantDto);

    }

    @Override
    public void supprimerEntretienCourant(Long ongletId, Long idEntretienCourant) {
        batimentImmobilisationMobilierOngletManager.supprimerEntretienCourantFromOnglet(ongletId, idEntretienCourant);

    }

    @Override
    public void updateEntretienCourantPartiel(Long ongletId, Long entretienCourantId, EntretienCourantDto entretienCourantDto) {
        batimentImmobilisationMobilierOngletManager.updateEntretienCourantPartiel(ongletId, entretienCourantId, entretienCourantDto);

    }

    @Override
    public void ajouterMobilierElectromenager(Long id, MobilierElectromenagerDto mobilierElectromenagerDto) {
        batimentImmobilisationMobilierOngletManager.ajouterMobilierElectromenager(id, mobilierElectromenagerDto);

    }

    @Override
    public void supprimerMobilierElectromenager(Long ongletId, Long idMobilierElectromenager) {
        batimentImmobilisationMobilierOngletManager.supprimerMobilierElectromenagerFromOnglet(ongletId, idMobilierElectromenager);

    }

    @Override
    public void updateMobilierElectromenagerPartiel(Long ongletId, Long mobilierElectromenagerId, MobilierElectromenagerDto mobilierElectromenagerDto) {
        batimentImmobilisationMobilierOngletManager.updateMobilierElectromenagerPartiel(ongletId, mobilierElectromenagerId, mobilierElectromenagerDto);

    }
}
