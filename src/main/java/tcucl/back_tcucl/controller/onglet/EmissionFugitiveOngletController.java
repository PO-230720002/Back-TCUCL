package tcucl.back_tcucl.controller.onglet;

import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.annotationPersonnalisee.checkRoleOnglet;
import tcucl.back_tcucl.dto.MachineEmissionFugitiveDto;
import tcucl.back_tcucl.entity.onglet.EmissionFugitiveOnglet;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.enums.EnumEmissionFugitive_TypeFluide;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.enums.EnumEmissionFugitive_TypeMachine;
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
    public EmissionFugitiveOnglet getEmissionFugitiveOngletById(@PathVariable(name = "id") Long id) {
        return emissionFugitiveOngletService.getEmissionFugitiveOngletById(id);
    }


    @PostMapping(REST_MACHINE)
    @checkRoleOnglet
    public void ajouterMachine(@PathVariable(name = "id") Long id, @RequestBody MachineEmissionFugitiveDto machineEmissionFugitiveDto) {
        emissionFugitiveOngletService.ajouterMachine(id, machineEmissionFugitiveDto);
    }


    @DeleteMapping(REST_MACHINE + REST_MACHINE_ID)
    @checkRoleOnglet
    public void supprimerMachine(@PathVariable(name = "id") Long ongletId, @RequestParam(name = "machineId") Long machineId) {
        emissionFugitiveOngletService.supprimerMachine(ongletId, machineId);
    }


    @PatchMapping(REST_MACHINE + REST_MACHINE_ID + REST_MODIFIER_NOM_MACHINE)
    @checkRoleOnglet
    public void setNomMachine(@PathVariable(name = "id") Long ongletId, @RequestParam(name = "machineId") Long machineId, String nomMachine) {
        emissionFugitiveOngletService.setNomMachine(ongletId, machineId, nomMachine);
    }

    @PatchMapping(REST_MACHINE  + REST_MACHINE_ID + REST_MODIFIER_DESCRIPTION_MACHINE)
    @checkRoleOnglet
    public void setDescriptionMachine(@PathVariable(name = "id") Long ongletId, @RequestParam(name = "machineId") Long machineId, String descriptionMachine) {
        emissionFugitiveOngletService.setDescriptionMachine(ongletId, machineId, descriptionMachine);
    }

    @PatchMapping(REST_MACHINE + REST_MACHINE_ID + REST_MODIFIER_TYPE_FLUIDE_MACHINE)
    @checkRoleOnglet
    public void setValeurEnumTypeFluide(@PathVariable(name = "id") Long ongletId, @RequestParam(name = "machineId") Long machineId, EnumEmissionFugitive_TypeFluide typeFluide) {
        emissionFugitiveOngletService.setValeurEnumTypeFluide(ongletId, machineId, typeFluide);
    }

    @PatchMapping(REST_MACHINE + REST_MACHINE_ID + REST_MODIFIER_QUANTITE_FLUIDE_MACHINE)
    @checkRoleOnglet
    public void setQuantiteFluideKg(@PathVariable(name = "id") Long ongletId, @RequestParam(name = "machineId") Long machineId, Float quantiteFluideKg) {
        emissionFugitiveOngletService.setQuantiteFluideKg(ongletId, machineId, quantiteFluideKg);
    }

    @PatchMapping(REST_MACHINE + REST_MACHINE_ID + REST_MODIFIER_TAUX_DE_FUITE_CONNU_MACHINE)
    @checkRoleOnglet
    public void setTauxDeFuiteConnu(@PathVariable(name = "id") Long ongletId, @RequestParam(name = "machineId") Long machineId, Boolean tauxDeFuiteConnu) {
        emissionFugitiveOngletService.setTauxDeFuiteConnu(ongletId, machineId, tauxDeFuiteConnu);
    }

    @PatchMapping(REST_MACHINE + REST_MACHINE_ID + REST_MODIFIER_TAUX_DE_FUITE_MACHINE)
    @checkRoleOnglet
    public void setTauxDeFuite(@PathVariable(name = "id") Long ongletId, @RequestParam(name = "machineId") Long machineId, Float tauxDeFuite) {
        emissionFugitiveOngletService.setTauxDeFuite(ongletId, machineId, tauxDeFuite);
    }

    @PatchMapping(REST_MACHINE + REST_MACHINE_ID + REST_MODIFIER_TYPE_MACHINE_MACHINE)
    @checkRoleOnglet
    public void setValeurEnumTypeMachine(@PathVariable(name = "id") Long ongletId, @RequestParam(name = "machineId") Long machineId, EnumEmissionFugitive_TypeMachine typeMachine) {
        emissionFugitiveOngletService.setValeurEnumTypeMachine(ongletId, machineId, typeMachine);
    }

}
