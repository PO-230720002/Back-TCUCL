package tcucl.back_tcucl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.dto.*;
import tcucl.back_tcucl.service.EntiteService;
import tcucl.back_tcucl.service.ParametreService;
import tcucl.back_tcucl.service.UtilisateurService;

import static tcucl.back_tcucl.Constante.*;

@RestController
@RequestMapping("/parametre")
public class ParametreController {

    private final UtilisateurService utilisateurService;
    private final EntiteService entiteService;
    private final ParametreService parametreService;

    public ParametreController(UtilisateurService utilisateurService, EntiteService entiteService, ParametreService parametreService) {
        this.utilisateurService = utilisateurService;
        this.entiteService = entiteService;
        this.parametreService = parametreService;
    }


    @PatchMapping(MODIFIER_UTILISATEUR_UTILISATEUR + ID)
    public ResponseEntity<?> modifierUtilisateurParUtilisateur(@PathVariable("id") Long idUtilisateur, @RequestBody ModificationUtilisateurParUtilisateurDto modificationUtilisateurParUtilisateurDto) {
        utilisateurService.modifierUtilisateurParUtilisateur(idUtilisateur, modificationUtilisateurParUtilisateurDto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(MODIFIER_UTILISATEUR_ADMIN + ID)
    public ResponseEntity<?> modifierUtilisateurParAdmin(@PathVariable("id") Long idUtilisateur, @RequestBody ModificationUtilisateurParAdminDto modificationUtilisateurParAdminDto) {
        utilisateurService.modifierUtilisateurParAdmin(idUtilisateur, modificationUtilisateurParAdminDto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(MODIFIER_EST_ADMIN + ID)
    public ResponseEntity<?> modifierEstAdmin(@PathVariable("id") Long idUtilisateur, @RequestBody boolean estAdmin) {
        ;
        return ResponseEntity.ok(utilisateurService.modifierEstAdmin(idUtilisateur, estAdmin));
    }


    @PostMapping(CHANGE_MDP)
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        return parametreService.changePassword(changePasswordDto);
    }

    @PostMapping()
    public ResponseEntity<?> creerEntite(CreationEntiteDto creationEntiteDto) {
        parametreService.ajouterEntite(creationEntiteDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public ResponseEntity<?> inscrireUtilisateur(@RequestBody InscriptionDto inscriptionDto) {
        return ResponseEntity.ok(utilisateurService.inscrireUtilisateur(inscriptionDto));
    }

    @GetMapping(UTILISATEUR_ENTITE + ID)
    public ResponseEntity<?> getAllUtilisateurParEntiteId(@PathVariable("id") Long idEntite) {
        return ResponseEntity.ok(utilisateurService.getAllUtilisateurParEntiteId(idEntite));
    }

    @GetMapping(ENTITE + ID)
    public ResponseEntity<?> getEntiteById(Long id) {
        return ResponseEntity.ok(entiteService.getEntiteById(id));
    }


}
