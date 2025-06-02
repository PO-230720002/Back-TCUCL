package tcucl.back_tcucl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.service.AnneeService;
import tcucl.back_tcucl.service.EntiteService;

import static tcucl.back_tcucl.controller.ControllerConstante.*;

@RestController
@RequestMapping(REST_GENERAL + REST_ENTITE_ID)
public class AccueilController {

    private final AnneeService anneeService;

    public AccueilController(AnneeService entiteService) {
        this.anneeService = entiteService;
    }

    @GetMapping()
    @PreAuthorize("hasRole('ROLE_ENTITE_' + #entiteId)")
    public ResponseEntity<?> getongletIdListForEntiteAndAnnee(@PathVariable(value = "entiteId") Long entiteId,
                                                              @RequestParam(value="annee") Integer annee) {
        return ResponseEntity.ok(anneeService.getongletIdListForEntiteAndAnnee(entiteId, annee));
    }
}
