package tcucl.back_tcucl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.service.ParametreEnergieOngletService;

@RestController
@RequestMapping("/parametreEnergie")
public class ParametreEnergieController {

    private final ParametreEnergieOngletService parametreEnergieOngletService;

    public ParametreEnergieController(ParametreEnergieOngletService parametreEnergieOngletService) {
        this.parametreEnergieOngletService = parametreEnergieOngletService;
    }


    @PatchMapping("/{id}/ReseauVille")
    public ResponseEntity<Void> updateUseElecSpecifique(@PathVariable Long id, @RequestParam String nomReseauVille){
        parametreEnergieOngletService.setNomReseauVille(id, nomReseauVille);
        return ResponseEntity.ok().build();
    }


    @PatchMapping("/{id}/UniteBois")
    public ResponseEntity<Void> updateUniteBois(@PathVariable Long id, @RequestParam String uniteBois){
        parametreEnergieOngletService.setUniteBois(id, uniteBois);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/UniteFioul")
    public ResponseEntity<Void> updateUniteFioul(@PathVariable Long id, @RequestParam String uniteFioul){
        parametreEnergieOngletService.setUniteFioul(id, uniteFioul);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/UniteGaz")
    public ResponseEntity<Void> updateUniteGaz(@PathVariable Long id, @RequestParam String uniteGaz){
        parametreEnergieOngletService.setUniteGaz(id, uniteGaz);
        return ResponseEntity.ok().build();
    }
}
