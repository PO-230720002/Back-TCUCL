package tcucl.back_tcucl.controller.onglet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.annotationPersonnalisee.checkRoleOnglet;
import tcucl.back_tcucl.dto.onglet.EnergieOngletDto;
import tcucl.back_tcucl.entity.onglet.EnergieOnglet;
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
    public ResponseEntity<Void> updateEnergieOngletPartiel(@PathVariable(value = "id") Long id,
                                                           @RequestBody EnergieOngletDto dto) {
        energieOngletService.updateEnergieOngletPartiel(id, dto);
        return ResponseEntity.ok().build();
    }


}
