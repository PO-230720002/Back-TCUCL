package tcucl.back_tcucl.controller.onglet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.annotationPersonnalisee.checkRoleOnglet;
import tcucl.back_tcucl.dto.onglet.achat.AchatOngletDto;
import tcucl.back_tcucl.entity.onglet.AchatOnglet;
import tcucl.back_tcucl.service.AchatOngletService;

import static tcucl.back_tcucl.controller.ControllerConstante.REST_ACHAT_ONGLET;
import static tcucl.back_tcucl.controller.ControllerConstante.REST_ID;

@RestController
@RequestMapping(REST_ACHAT_ONGLET + REST_ID)
public class AchatController {

    private final AchatOngletService achatOngletService;

    public AchatController(AchatOngletService achatOngletService) {
        this.achatOngletService = achatOngletService;
    }

    @GetMapping()
    @checkRoleOnglet
    public ResponseEntity<?> getAchatOngletById(@PathVariable(value = "id") Long id) {
        AchatOnglet achatOngletById = achatOngletService.getAchatOngletById(id);
        AchatOngletDto body = new AchatOngletDto(achatOngletById);
        return ResponseEntity.ok(body);
    }

    @PatchMapping()
    @checkRoleOnglet
    public ResponseEntity<Void> updateAchatOngletPartiel(@PathVariable(value = "id") Long id,
                                                           @RequestBody AchatOngletDto dto) {
        achatOngletService.updateAchatOngletPartiel(id, dto);
        return ResponseEntity.ok().build();
    }
}
