package tcucl.back_tcucl.controller.onglet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.annotationPersonnalisee.checkRoleOnglet;
import tcucl.back_tcucl.dto.onglet.mobiliteDomicileTravail.MobiliteDomicileTravailOngletDto;
import tcucl.back_tcucl.entity.onglet.MobiliteDomicileTravailOnglet;
import tcucl.back_tcucl.service.MobiliteDomicileTravailOngletService;

import static tcucl.back_tcucl.controller.ControllerConstante.*;

@RestController
@RequestMapping(REST_MOBILITE_DOMICILE_TRAVAIL_ONGLET + REST_ID)
public class MobiliteDomicileTravailOngletController {

    private final MobiliteDomicileTravailOngletService mobiliteDomicileTravailOngletService;

    public MobiliteDomicileTravailOngletController(MobiliteDomicileTravailOngletService mobiliteDomicileTravailOngletService) {
        this.mobiliteDomicileTravailOngletService = mobiliteDomicileTravailOngletService;
    }

    @GetMapping()
    @checkRoleOnglet
    public ResponseEntity<?> getMobiliteDomicileTravailOngletById(@PathVariable(value = "id") Long id) {
        MobiliteDomicileTravailOnglet mobiliteDomicileTravailOngletById = mobiliteDomicileTravailOngletService.getMobiliteDomicileTravailOngletById(id);
        MobiliteDomicileTravailOngletDto body = new MobiliteDomicileTravailOngletDto(mobiliteDomicileTravailOngletById);
        return ResponseEntity.ok(body);
    }

    @PatchMapping()
    @checkRoleOnglet
    public ResponseEntity<Void> updateMobiliteDomicileTravailOngletPartiel(@PathVariable(value = "id") Long id,
                                                                           @RequestBody MobiliteDomicileTravailOngletDto dto) {
        mobiliteDomicileTravailOngletService.updateMobiliteDomicileTravailOngletPartiel(id, dto);
        return ResponseEntity.ok().build();
    }


}