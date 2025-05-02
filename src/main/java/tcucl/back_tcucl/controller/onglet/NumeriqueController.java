package tcucl.back_tcucl.controller.onglet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.annotationPersonnalisee.checkRoleOnglet;
import tcucl.back_tcucl.dto.onglet.numerique.EquipementNumeriqueDto;
import tcucl.back_tcucl.dto.onglet.numerique.NumeriqueOngletDto;
import tcucl.back_tcucl.entity.onglet.numerique.NumeriqueOnglet;
import tcucl.back_tcucl.service.NumeriqueOngletService;

import static tcucl.back_tcucl.controller.ControllerConstante.*;

@RestController
@RequestMapping(REST_NUMERIQUE_ONGLET + REST_ID)
public class NumeriqueController {

    private final NumeriqueOngletService numeriqueOngletService;


    public NumeriqueController(NumeriqueOngletService numeriqueOngletService) {
        this.numeriqueOngletService = numeriqueOngletService;
    }

    @GetMapping
    @checkRoleOnglet
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
        NumeriqueOnglet numeriqueOngletById = numeriqueOngletService.getNumeriqueOngletById(id);
        NumeriqueOngletDto numeriqueOngletDto = new NumeriqueOngletDto(numeriqueOngletById);
        return ResponseEntity.ok(numeriqueOngletDto);
    }

    @PatchMapping
    @checkRoleOnglet
    public ResponseEntity<Void> updateNumeriqueOngletPartiel(@PathVariable(name = "id") Long id,
                                                             @RequestBody NumeriqueOngletDto numeriqueOngletDto) {
        numeriqueOngletService.updateNumeriqueOngletPartiel(id, numeriqueOngletDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(REST_EQUIPEMENT_NUMERIQUE)
    @checkRoleOnglet
    public ResponseEntity<Void> ajouterEquipementNumerique(@PathVariable(name = "id") Long id,
                                                           @RequestBody EquipementNumeriqueDto equipementNumeriqueDto) {
        numeriqueOngletService.ajouterEquipementNumerique(id, equipementNumeriqueDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(REST_EQUIPEMENT_NUMERIQUE + REST_EQUIPEMENT_NUMERIQUE_ID)
    @checkRoleOnglet
    public ResponseEntity<Void> supprimerEquipementNumerique(@PathVariable(name = "id") Long ongletId,
                                                @PathVariable(name = "equipementNumeriqueId") Long equipementNumeriqueId) {
        numeriqueOngletService.supprimerEquipementNumerique(ongletId, equipementNumeriqueId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(REST_EQUIPEMENT_NUMERIQUE + REST_EQUIPEMENT_NUMERIQUE_ID)
    @checkRoleOnglet
    public ResponseEntity<Void> updateVoyagePartiel(@PathVariable(name = "id") Long ongletId,
                                                    @PathVariable(name = "equipementNumeriqueId") Long equipementNumeriqueId,
                                                    @RequestBody EquipementNumeriqueDto dto) {
        numeriqueOngletService.updateEquipementNumeriquePartiel(ongletId, equipementNumeriqueId, dto);
        return ResponseEntity.ok().build();
    }
}
