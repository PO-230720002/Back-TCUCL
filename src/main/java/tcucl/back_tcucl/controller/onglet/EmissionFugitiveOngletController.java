package tcucl.back_tcucl.controller.onglet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.annotationPersonnalisee.checkRoleOnglet;
import tcucl.back_tcucl.dto.onglet.emissionFugitive.MachineEmissionFugitiveDto;
import tcucl.back_tcucl.dto.onglet.emissionFugitive.EmissionFugitiveOngletDto;
import tcucl.back_tcucl.entity.onglet.EmissionFugitiveOnglet;
import tcucl.back_tcucl.service.EmissionFugitiveOngletService;

import static tcucl.back_tcucl.controller.ControllerConstante.*;

@RestController
@RequestMapping(REST_EMISSION_FUGITIVE_ONGLET+REST_ID)
public class EmissionFugitiveOngletController {

    private final EmissionFugitiveOngletService emissionFugitiveOngletService;

    public EmissionFugitiveOngletController(EmissionFugitiveOngletService emissionFugitiveOngletService) {
        this.emissionFugitiveOngletService = emissionFugitiveOngletService;
    }

    @GetMapping()
    @checkRoleOnglet
    public ResponseEntity<?> getEmissionFugitiveOngletById(@PathVariable(name = "id") Long id) {
        EmissionFugitiveOnglet emissionFugitiveOngletById = emissionFugitiveOngletService.getEmissionFugitiveOngletById(id);
        EmissionFugitiveOngletDto emissionFugitiveOngletDto = new EmissionFugitiveOngletDto(emissionFugitiveOngletById);
        return ResponseEntity.ok(emissionFugitiveOngletDto);
    }

    @PatchMapping
    @checkRoleOnglet
    public ResponseEntity<Void> updateEmissionFugitiveOnglet(@PathVariable(name = "id") Long id, @RequestBody EmissionFugitiveOngletDto emissionFugitiveOngletDto) {
        emissionFugitiveOngletService.updateEmissionFugitiveOnglet(id, emissionFugitiveOngletDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(REST_MACHINE)
    @checkRoleOnglet
    public ResponseEntity<Void> ajouterMachine(@PathVariable(name = "id") Long id, @RequestBody MachineEmissionFugitiveDto machineEmissionFugitiveDto) {
        emissionFugitiveOngletService.ajouterMachine(id, machineEmissionFugitiveDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(REST_MACHINE + REST_MACHINE_ID)
    @checkRoleOnglet
    public ResponseEntity<Void> supprimerMachine(@PathVariable(name = "id") Long ongletId, @RequestParam(name = "machineId") Long machineId) {
        emissionFugitiveOngletService.supprimerMachine(ongletId, machineId);
        return ResponseEntity.ok().build();

    }

    @PatchMapping(REST_MACHINE + REST_MACHINE_ID)
    @checkRoleOnglet
    public ResponseEntity<Void> updateMachinePartiel(@PathVariable(name = "id") Long ongletId, @RequestParam(name = "machineId") Long machineId, MachineEmissionFugitiveDto machineEmissionFugitiveDto) {
        emissionFugitiveOngletService.updateMachinePartiel(ongletId, machineId, machineEmissionFugitiveDto);
        return ResponseEntity.ok().build();
    }
}
