package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.energie.EnergieOngletDto;
import tcucl.back_tcucl.dto.onglet.energie.EnergieResultatDto;
import tcucl.back_tcucl.entity.FacteurEmission;
import tcucl.back_tcucl.entity.onglet.energie.EnergieOnglet;
import tcucl.back_tcucl.entity.onglet.energie.enums.EnumEnergie_UniteGaz;
import tcucl.back_tcucl.manager.EnergieOngletManager;
import tcucl.back_tcucl.service.EnergieOngletService;
import tcucl.back_tcucl.service.FacteurEmissionService;

@Service
public class EnergieOngletServiceImpl implements EnergieOngletService {

    private final EnergieOngletManager energieOngletManager;
    private final FacteurEmissionService facteurEmissionService;

    public EnergieOngletServiceImpl(EnergieOngletManager energieOngletManager, FacteurEmissionService facteurEmissionService) {
        this.energieOngletManager = energieOngletManager;
        this.facteurEmissionService = facteurEmissionService;
    }

    @Override
    public EnergieOnglet getEnergieOngletById(Long ongletId) {
        return energieOngletManager.getEnergieOngletById(ongletId);
    }

    @Override
    public void updateEnergieOngletPartiel(Long ongletId, EnergieOngletDto energieOngletDto) {
        energieOngletManager.updateEnergieOngletPartiel(ongletId, energieOngletDto);
    }

    @Override
    public EnergieResultatDto getEnergieResult(Long ongletId) {
        EnergieOnglet energieOnglet = energieOngletManager.getEnergieOngletById(ongletId);
        EnergieResultatDto energieResultatDto = new EnergieResultatDto();

        FacteurEmission facteurEmission = facteurEmissionService.findByCategorieAndTypeAndUnite("ENERGIE", "Gaz", "kgCO2e/"+energieOnglet.getUniteGaz().toString());
        energieResultatDto.setConsoGaz((facteurEmission.getFacteurEmission() * energieOnglet.getConsoGaz())/1000);

        facteurEmission = facteurEmissionService.findByCategorieAndTypeAndUnite("ENERGIE", "Fioul", "kgCO2e/"+energieOnglet.getUniteFioul().toString());
        energieResultatDto.setConsoGaz((facteurEmission.getFacteurEmission() * energieOnglet.getConsoFioul())/1000);

        facteurEmission = facteurEmissionService.findByCategorieAndTypeAndUnite("ENERGIE", "Bois granulé français", "kgCO2e/"+energieOnglet.getUniteBois().toString());
        energieResultatDto.setConsoGaz((facteurEmission.getFacteurEmission() * energieOnglet.getConsoBois())/1000);

        facteurEmission = facteurEmissionService.findByCategorieAndTypeAndUnite("ENERGIE", "Réseau de chaleur Lambersart", "kgCO2e/");
        energieResultatDto.setConsoGaz((facteurEmission.getFacteurEmission() * energieOnglet.getConsoBois())/1000);


        return null;
    }
}
