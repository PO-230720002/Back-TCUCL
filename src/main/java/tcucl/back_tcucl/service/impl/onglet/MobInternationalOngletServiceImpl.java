package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.mobInternational.MobInternationalOngletDto;
import tcucl.back_tcucl.dto.onglet.mobInternational.VoyageDto;
import tcucl.back_tcucl.entity.onglet.mobInternationale.MobInternationalOnglet;
import tcucl.back_tcucl.manager.MobInternationalOngletManager;
import tcucl.back_tcucl.service.MobInternationalOngletService;

@Service
public class MobInternationalOngletServiceImpl implements MobInternationalOngletService {

    private final MobInternationalOngletManager mobInternationalOngletManager;

    public MobInternationalOngletServiceImpl(MobInternationalOngletManager mobInternationalOngletManager) {
        this.mobInternationalOngletManager = mobInternationalOngletManager;
    }

    @Override
    public MobInternationalOnglet getMobInternationalOngletById(Long ongletId) {
        return mobInternationalOngletManager.getMobInternationalOngletById(ongletId);
    }

    @Override
    public void updateMobInternationalOngletPartiel(Long ongletId, MobInternationalOngletDto mobInternationalOngletDto) {
        mobInternationalOngletManager.updateMobInternationalOngletPartiel(ongletId, mobInternationalOngletDto);
    }

    @Override
    public void ajouterVoyage(Long ongletId, VoyageDto voyageDto) {
        mobInternationalOngletManager.ajouterVoyage(ongletId, voyageDto);
    }

    @Override
    public void supprimerVoyage(Long ongletId, Long voyageId) {
        mobInternationalOngletManager.supprimerVoyage(ongletId, voyageId);
    }

    @Override
    public void updateVoyagePartiel(Long ongletId, Long voyageId, VoyageDto voyageDto) {
        mobInternationalOngletManager.updateVoyagePartiel(ongletId, voyageId, voyageDto);
    }
}
