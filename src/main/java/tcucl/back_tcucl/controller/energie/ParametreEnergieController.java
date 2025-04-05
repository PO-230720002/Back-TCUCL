package tcucl.back_tcucl.controller.energie;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.service.ParametreEnergieOngletService;

import static tcucl.back_tcucl.controller.ControllerConstante.*;

@RestController
@RequestMapping(PARAMETRE_ENERGIE)
public class ParametreEnergieController {

    private final ParametreEnergieOngletService parametreEnergieOngletService;

    public ParametreEnergieController(ParametreEnergieOngletService parametreEnergieOngletService) {
        this.parametreEnergieOngletService = parametreEnergieOngletService;
    }


    @PatchMapping(REST_ID + RESEAU_VILLE)
    public ResponseEntity<Void> updateUseElecSpecifique(@PathVariable Long id, @RequestParam String nomReseauVille){
        parametreEnergieOngletService.setNomReseauVille(id, nomReseauVille);
        return ResponseEntity.ok().build();
    }


    @PatchMapping(REST_ID + UNITE_BOIS)
    public ResponseEntity<Void> updateUniteBois(@PathVariable Long id, @RequestParam String uniteBois){
        parametreEnergieOngletService.setUniteBois(id, uniteBois);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(REST_ID + UNITE_FIOUL)
    public ResponseEntity<Void> updateUniteFioul(@PathVariable Long id, @RequestParam String uniteFioul){
        parametreEnergieOngletService.setUniteFioul(id, uniteFioul);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(REST_ID + UNITE_GAZ)
    public ResponseEntity<Void> updateUniteGaz(@PathVariable Long id, @RequestParam String uniteGaz){
        parametreEnergieOngletService.setUniteGaz(id, uniteGaz);
        return ResponseEntity.ok().build();
    }
}
