package tcucl.back_tcucl.controller.onglet;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.annotationPersonnalisee.checkRoleOnglet;
import tcucl.back_tcucl.dto.onglet.EnergieOngletDto;
import tcucl.back_tcucl.entity.onglet.EnergieOnglet;
import tcucl.back_tcucl.dto.onglet.EnergieOngletUpdateDto;
import tcucl.back_tcucl.entity.onglet.EnergieOnglet;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_NomReseauVille;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteBois;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteFioul;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteGaz;
import tcucl.back_tcucl.service.EnergieOngletService;

import static tcucl.back_tcucl.controller.ControllerConstante.*;

@RestController
@RequestMapping(REST_ENERGIE_ONGLET + REST_ID)
public class EnergieOngletController {

    private final EnergieOngletService energieOngletService;

    public EnergieOngletController(EnergieOngletService energieOngletService) {
        this.energieOngletService = energieOngletService;
    }

    @GetMapping()
    @checkRoleOnglet
    public ResponseEntity<?> getEnergieOngletById(@PathVariable(value = "id") Long id) {

        EnergieOnglet energieOngletById = energieOngletService.getEnergieOngletById(id);
        EnergieOngletDto body = new EnergieOngletDto(energieOngletById);
        return ResponseEntity.ok(body);
    }

    @PatchMapping()
    @checkRoleOnglet
    public ResponseEntity<Void> updateEnergieOngletPartiel(@PathVariable Long id,
                                                           @RequestBody EnergieOngletUpdateDto dto) {
        energieOngletService.updateEnergieOngletPartiel(id, dto);
        return ResponseEntity.ok().build();
    }

//    @PostMapping(REST_CREATE_RANDOM)
//    public ResponseEntity<?> createRandomEnergieOnglet() {
//        return ResponseEntity.ok(energieOngletService.createRandomEnergieOnglet());
//    }

//    @PatchMapping()
//    @checkRoleOnglet
//    public ResponseEntity<?> updateEnergieOnglet( @RequestBody EnergieOnglet energieOnglet) {
//        return ResponseEntity.ok(energieOngletService.updateEnergieOnglet(energieOnglet));
//    }
//
//
//    @PatchMapping(REST_EST_TERMINE)
//    @checkRoleOnglet
//    public ResponseEntity<Void> updateEstTermine(@PathVariable Long id, @RequestBody boolean estTermine) {
//        energieOngletService.setEstTermine(id, estTermine);
//        return ResponseEntity.ok().build();
//    }
//
//
//    @PatchMapping(value = REST_CONSO_GAZ)
//    @checkRoleOnglet
//    public ResponseEntity<Void> updateConsoGaz(@PathVariable Long id, @RequestBody Float consoGaz) {
//        energieOngletService.setConsoGaz(id, consoGaz);
//        return ResponseEntity.ok().build();
//    }
//
//    @PatchMapping(REST_CONSO_FIOUL)
//    @checkRoleOnglet
//    public ResponseEntity<Void> updateConsoFioul(@PathVariable Long id, @RequestBody Float consoFioul) {
//        energieOngletService.setConsoFioul(id, consoFioul);
//        return ResponseEntity.ok().build();
//    }
//
//    @PatchMapping(REST_CONSO_BOIS)
//    @checkRoleOnglet
//    public ResponseEntity<Void> updateConsoBois(@PathVariable Long id, @RequestBody Float consoBois) {
//        energieOngletService.setConsoBois(id, consoBois);
//        return ResponseEntity.ok().build();
//    }
//
//    @PatchMapping(REST_CONSO_RESEAU_VILLE)
//    @checkRoleOnglet
//    public ResponseEntity<Void> updateConsoReseauVille(@PathVariable Long id, @RequestBody Float consoReseauVille) {
//        energieOngletService.setConsoReseauVille(id, consoReseauVille);
//        return ResponseEntity.ok().build();
//    }
//
//    @PatchMapping(REST_CONSO_ELEC_CHAUFFAGE)
//    @checkRoleOnglet
//    public ResponseEntity<Void> updateConsoElecChauffage(@PathVariable Long id, @RequestBody Float consoElecChauffage) {
//        energieOngletService.setConsoElecChauffage(id, consoElecChauffage);
//        return ResponseEntity.ok().build();
//    }
//
//    @PatchMapping(REST_CONSO_ELEC_SPECIFIQUE)
//    @checkRoleOnglet
//    public ResponseEntity<Void> updateConsoElecSpecifique(@PathVariable Long id, @RequestBody Float consoElecSpecifique) {
//        energieOngletService.setConsoElecSpecifique(id, consoElecSpecifique);
//        return ResponseEntity.ok().build();
//    }
//
//    @PatchMapping(REST_CONSO_EAU)
//    @checkRoleOnglet
//    public ResponseEntity<Void> updateConsoEau(@PathVariable Long id, @RequestBody Float consoEau) {
//        energieOngletService.setConsoEau(id, consoEau);
//        return ResponseEntity.ok().build();
//    }
//
//    @PatchMapping(REST_NOTE)
//    @checkRoleOnglet
//    public ResponseEntity<Void> updateNote(@PathVariable Long id, @RequestBody String note) {
//        energieOngletService.setNote(id, note);
//        return ResponseEntity.ok().build();
//    }
//
//    @PatchMapping(RESEAU_VILLE)
//    @checkRoleOnglet
//    public ResponseEntity<Void> updateUseElecSpecifique(@PathVariable Long id, @RequestParam EnumEnergie_NomReseauVille nomReseauVille){
//        energieOngletService.setNomReseauVille(id, nomReseauVille);
//        return ResponseEntity.ok().build();
//    }
//
//
//    @PatchMapping(REST_UNITE_BOIS)
//    @checkRoleOnglet
//    public ResponseEntity<Void> updateUniteBois(@PathVariable Long id, @RequestParam EnumEnergie_UniteBois uniteBois){
//        energieOngletService.setUniteBois(id, uniteBois);
//        return ResponseEntity.ok().build();
//    }
//
//    @PatchMapping(REST_UNITE_FIOUL)
//    @checkRoleOnglet
//    public ResponseEntity<Void> updateUniteFioul(@PathVariable Long id, @RequestParam EnumEnergie_UniteFioul uniteFioul){
//        energieOngletService.setUniteFioul(id, uniteFioul);
//        return ResponseEntity.ok().build();
//    }
//
//    @PatchMapping(REST_UNITE_GAZ)
//    @checkRoleOnglet
//    public ResponseEntity<Void> updateUniteGaz(@PathVariable Long id, @RequestParam EnumEnergie_UniteGaz uniteGaz){
//        energieOngletService.setUniteGaz(id, uniteGaz);
//        return ResponseEntity.ok().build();
//    }
}
