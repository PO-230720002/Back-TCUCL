package tcucl.back_tcucl.controller.onglet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.annotationPersonnalisee.checkRoleOnglet;
import tcucl.back_tcucl.dto.onglet.dechet.DechetOngletDto;
import tcucl.back_tcucl.entity.onglet.DechetOnglet;
import tcucl.back_tcucl.service.DechetOngletService;

import static tcucl.back_tcucl.controller.ControllerConstante.*;

@RestController
@RequestMapping(REST_DECHET_ONGLET + REST_ID)
public class DechetOngletController {

    private final DechetOngletService dechetOngletService;

    public DechetOngletController(DechetOngletService dechetOngletService) {
        this.dechetOngletService = dechetOngletService;
    }

    @GetMapping()
    @checkRoleOnglet
    public ResponseEntity<?> getDechetOngletById(@PathVariable(value = "id") Long id) {
        DechetOnglet dechetOngletById = dechetOngletService.getDechetOngletById(id);
        DechetOngletDto body = new DechetOngletDto(dechetOngletById);
        return ResponseEntity.ok(body);
    }

    @PatchMapping()
    @checkRoleOnglet
    public ResponseEntity<Void> updateDechetOngletPartiel(@PathVariable(value = "id") Long id,
                                                           @RequestBody DechetOngletDto dto) {
        dechetOngletService.updateDechetOngletPartiel(id, dto);
        return ResponseEntity.ok().build();
    }


}
