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
@RequestMapping(REST_MOB_INTERNATIONALE_ONGLET + REST_ID)
public class MobInternationalOngletController {

    private final MobInternationalOngletService mobInternationalOngletService;

    public MobInternationalOngletController(MobInternationalOngletService mobInternationalOngletService) {
        this.mobInternationalOngletService = mobInternationalOngletService;
    }

    @GetMapping
    @checkRoleOnglet
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
        MobInternationalOnglet mobInternationalOngletById = mobInternationalOngletService.getMobInternationalOngletById(id);
        MobInternationalOngletDto mobInternationalOngletDto = new MobInternationalOngletDto(mobInternationalOngletById);
        return ResponseEntity.ok(mobInternationalOngletDto);
    }

    @PatchMapping
    @checkRoleOnglet
    public ResponseEntity<Void> updatePartiel(@PathVariable(name = "id") Long id,
                                              @RequestBody MobInternationalOngletDto mobInternationalOngletDto) {
        mobInternationalOngletService.updateMobInternationalOngletPartiel(id, mobInternationalOngletDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(REST_VOYAGE)
    @checkRoleOnglet
    public ResponseEntity<Void> ajouterVoyage(@PathVariable(name = "id") Long id,
                                              @RequestBody VoyageVersUneDestinationMobInternationaleDto voyageVersUneDestinationMobInternationaleDto) {
        mobInternationalOngletService.ajouterVoyage(id, voyageVersUneDestinationMobInternationaleDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(REST_VOYAGE + REST_VOYAGE_ID)
    @checkRoleOnglet
    public ResponseEntity<Void> supprimerVoyage(@PathVariable(name = "id") Long ongletId,
                                                @PathVariable(name = "voyageId") Long voyageId) {
        mobInternationalOngletService.supprimerVoyage(ongletId, voyageId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(REST_VOYAGE + REST_VOYAGE_ID)
    @checkRoleOnglet
    public ResponseEntity<Void> updateVoyagePartiel(@PathVariable(name = "id") Long ongletId,
                                                    @PathVariable(name = "voyageId") Long voyageId,
                                                    @RequestBody VoyageVersUneDestinationMobInternationaleDto dto) {
        mobInternationalOngletService.updateVoyagePartiel(ongletId, voyageId, dto);
        return ResponseEntity.ok().build();
    }
}