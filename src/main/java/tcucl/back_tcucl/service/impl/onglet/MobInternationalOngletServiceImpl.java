package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.mobInternational.MobInternationalOngletDto;
import tcucl.back_tcucl.dto.onglet.mobInternational.VoyageVersUneDestinationMobInternationaleDto;
import tcucl.back_tcucl.entity.onglet.MobInternationalOnglet;
import tcucl.back_tcucl.manager.MobInternationalOngletManager;
import tcucl.back_tcucl.service.MobInternationalOngletService;

@Service
public class MobInternationalOngletServiceImpl implements MobInternationalOngletService {

    private final MobInternationalOngletManager mobInternationalOngletManager;

    public MobInternationalOngletServiceImpl(MobInternationalOngletManager mobInternationalOngletManager) {
        this.mobInternationalOngletManager = mobInternationalOngletManager;
    }

    @Override
    public MobInternationalOnglet getMobInternationalOngletById(Long id) {
        return mobInternationalOngletManager.getMobInternationalOngletById(id);
    }

    @Override
    public void updateMobInternationalOngletPartiel(Long id, MobInternationalOngletDto mobInternationalOngletDto) {
        mobInternationalOngletManager.updateMobInternationalOngletPartiel(id, mobInternationalOngletDto);
    }

    @Override
    public void ajouterVoyage(Long id, VoyageVersUneDestinationMobInternationaleDto voyageVersUneDestinationMobInternationaleDto) {
        mobInternationalOngletManager.ajouterVoyage(id, voyageVersUneDestinationMobInternationaleDto);
    }

    @Override
    public void supprimerVoyage(Long ongletId, Long voyageId) {
        mobInternationalOngletManager.supprimerVoyage(ongletId, voyageId);
    }

    @Override
    public void updateVoyagePartiel(Long ongletId, Long voyageId, VoyageVersUneDestinationMobInternationaleDto dto) {
        mobInternationalOngletManager.updateVoyagePartiel(ongletId, voyageId, dto);
    }
}
