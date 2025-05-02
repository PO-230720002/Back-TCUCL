package tcucl.back_tcucl.controller.onglet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.annotationPersonnalisee.checkRoleOnglet;
import tcucl.back_tcucl.dto.onglet.general.GeneralOngletDto;
import tcucl.back_tcucl.entity.onglet.GeneralOnglet;
import tcucl.back_tcucl.service.GeneralOngletService;

import static tcucl.back_tcucl.controller.ControllerConstante.*;

@RestController
@RequestMapping(REST_GENERAL_ONGLET + REST_ID)
public class GeneralOngletController {

    private final GeneralOngletService generalOngletService;

    public GeneralOngletController(GeneralOngletService generalOngletService) {
        this.generalOngletService = generalOngletService;
    }

    @GetMapping()
    @checkRoleOnglet
    public ResponseEntity<?> getGeneralOngletById(@PathVariable(value = "id") Long id) {
        GeneralOnglet generalOngletById = generalOngletService.getGeneralOngletById(id);
        GeneralOngletDto body = new GeneralOngletDto(generalOngletById);
        return ResponseEntity.ok(body);
    }

    @PatchMapping()
    @checkRoleOnglet
    public ResponseEntity<Void> updateGeneralOngletPartiel(@PathVariable(value = "id") Long id,
                                                           @RequestBody GeneralOngletDto dto) {
        generalOngletService.updateGeneralOngletPartiel(id, dto);
        return ResponseEntity.ok().build();
    }


}
