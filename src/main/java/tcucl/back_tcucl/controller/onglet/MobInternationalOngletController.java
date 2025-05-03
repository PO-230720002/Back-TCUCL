package tcucl.back_tcucl.controller.onglet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.annotationPersonnalisee.checkRoleOnglet;
import tcucl.back_tcucl.dto.onglet.mobInternational.MobInternationalOngletDto;
import tcucl.back_tcucl.dto.onglet.mobInternational.VoyageVersUneDestinationMobInternationaleDto;
import tcucl.back_tcucl.entity.onglet.mobInternationale.MobInternationalOnglet;
import tcucl.back_tcucl.service.MobInternationalOngletService;

import static tcucl.back_tcucl.controller.ControllerConstante.*;

@RestController
@RequestMapping(REST_MOB_INTERNATIONALE_ONGLET + REST_ONGLET_ID)
public class MobInternationalOngletController {

    private final MobInternationalOngletService mobInternationalOngletService;

    public MobInternationalOngletController(MobInternationalOngletService mobInternationalOngletService) {
        this.mobInternationalOngletService = mobInternationalOngletService;
    }

    @GetMapping
    @checkRoleOnglet
    public ResponseEntity<?> getById(@PathVariable(name = "ongletId") Long ongletId) {
        MobInternationalOnglet mobInternationalOngletById = mobInternationalOngletService.getMobInternationalOngletById(ongletId);
        MobInternationalOngletDto mobInternationalOngletDto = new MobInternationalOngletDto(mobInternationalOngletById);
        return ResponseEntity.ok(mobInternationalOngletDto);
    }

    @PatchMapping
    @checkRoleOnglet
    public ResponseEntity<Void> updatePartiel(@PathVariable(name = "ongletId") Long ongletId,
                                              @RequestBody MobInternationalOngletDto mobInternationalOngletDto) {
        mobInternationalOngletService.updateMobInternationalOngletPartiel(ongletId, mobInternationalOngletDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(REST_VOYAGE)
    @checkRoleOnglet
    public ResponseEntity<Void> ajouterVoyage(@PathVariable(name = "ongletId") Long ongletId,
                                              @RequestBody VoyageVersUneDestinationMobInternationaleDto voyageVersUneDestinationMobInternationaleDto) {
        mobInternationalOngletService.ajouterVoyage(ongletId, voyageVersUneDestinationMobInternationaleDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(REST_VOYAGE + REST_VOYAGE_ID)
    @checkRoleOnglet
    public ResponseEntity<Void> supprimerVoyage(@PathVariable(name = "ongletId") Long ongletId,
                                                @PathVariable(name = "voyageId") Long voyageId) {
        mobInternationalOngletService.supprimerVoyage(ongletId, voyageId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(REST_VOYAGE + REST_VOYAGE_ID)
    @checkRoleOnglet
    public ResponseEntity<Void> updateVoyagePartiel(@PathVariable(name = "ongletId") Long ongletId,
                                                    @PathVariable(name = "voyageId") Long voyageId,
                                                    @RequestBody VoyageVersUneDestinationMobInternationaleDto voyageVersUneDestinationMobInternationaleDto) {
        mobInternationalOngletService.updateVoyagePartiel(ongletId, voyageId, voyageVersUneDestinationMobInternationaleDto);
        return ResponseEntity.ok().build();
    }
}