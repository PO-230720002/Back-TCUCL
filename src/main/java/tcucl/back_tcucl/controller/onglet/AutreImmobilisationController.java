package tcucl.back_tcucl.controller.onglet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.annotationPersonnalisee.checkRoleOnglet;
import tcucl.back_tcucl.dto.onglet.autreImmobilisation.AutreImmobilisationOngletDto;
import tcucl.back_tcucl.entity.onglet.AutreImmobilisationOnglet;
import tcucl.back_tcucl.service.AutreImmobilisationOngletService;

import static tcucl.back_tcucl.controller.ControllerConstante.*;

@RestController
@RequestMapping(REST_AUTRE_IMMOBILISATION + REST_ID)
public class AutreImmobilisationController {


    private final AutreImmobilisationOngletService autreImmobilisationOngletService;


    public AutreImmobilisationController(AutreImmobilisationOngletService autreImmobilisationOngletService) {
        this.autreImmobilisationOngletService = autreImmobilisationOngletService;
    }

    @GetMapping()
    @checkRoleOnglet
    public ResponseEntity<?> getAutreImmobilisationOngletById(@PathVariable(value = "id") Long id) {
        AutreImmobilisationOnglet autreImmobilisationOngletById = autreImmobilisationOngletService.getAutreImmobilisationOngletById(id);
        AutreImmobilisationOngletDto body = new AutreImmobilisationOngletDto(autreImmobilisationOngletById);
        return ResponseEntity.ok(body);
    }

    @PatchMapping()
    @checkRoleOnglet
    public ResponseEntity<Void> updateAutreImmobilisationOngletPartiel(@PathVariable(value = "id") Long id,
                                                           @RequestBody AutreImmobilisationOngletDto dto) {
        autreImmobilisationOngletService.updateAutreImmobilisationOngletPartiel(id, dto);
        return ResponseEntity.ok().build();
    }


}
