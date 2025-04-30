package tcucl.back_tcucl.controller.onglet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.annotationPersonnalisee.checkRoleOnglet;
import tcucl.back_tcucl.dto.onglet.AutreMobFrOngletDto;
import tcucl.back_tcucl.entity.onglet.AutreMobFrOnglet;
import tcucl.back_tcucl.service.AutreMobFrOngletService;

import static tcucl.back_tcucl.controller.ControllerConstante.REST_AUTRE_MOB_FR;
import static tcucl.back_tcucl.controller.ControllerConstante.REST_ID;

@RestController
@RequestMapping(REST_AUTRE_MOB_FR + REST_ID)
public class AutreMobFrController {

    private final AutreMobFrOngletService autreMobFrOngletService;

    public AutreMobFrController(AutreMobFrOngletService autreMobFrOngletService) {
        this.autreMobFrOngletService = autreMobFrOngletService;
    }

    @GetMapping()
    @checkRoleOnglet
    public ResponseEntity<?> getAutreMobFrOngletById(@PathVariable(value = "id") Long id) {
        AutreMobFrOnglet autreMobFrOnglet = autreMobFrOngletService.getAutreMobFrOngletById(id);
        AutreMobFrOngletDto autreMobFrOngletDto = new AutreMobFrOngletDto(autreMobFrOnglet);
        return ResponseEntity.ok(autreMobFrOngletDto);
    }

    @PatchMapping
    @checkRoleOnglet
    public ResponseEntity<Void> updateAutreMobFrOngletPartiel(@PathVariable(value = "id") Long id, @RequestBody AutreMobFrOngletDto autreMobFrOngletDto) {
        autreMobFrOngletService.updateAutreMobFrOngletPartiel(id, autreMobFrOngletDto);
        return ResponseEntity.ok().build();
    }
}
