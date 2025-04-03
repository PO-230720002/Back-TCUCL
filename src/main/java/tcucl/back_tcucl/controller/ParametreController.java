package tcucl.back_tcucl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.dto.*;
import tcucl.back_tcucl.service.ParametreService;
import tcucl.back_tcucl.service.UtilisateurService;

import static tcucl.back_tcucl.Constante.*;

@RestController
@RequestMapping(PARAMETRE)
public class ParametreController {

    private final UtilisateurService utilisateurService;
    private final ParametreService parametreService;

    public ParametreController(UtilisateurService utilisateurService, ParametreService parametreService) {
        this.utilisateurService = utilisateurService;
        this.parametreService = parametreService;
    }

    //    Parametre perso
    @GetMapping(UTILISATEUR + ID)
    @PatchMapping(MODIFIER_UTILISATEUR_UTILISATEUR + ID)
    public ResponseEntity<?> modifierUtilisateurParUtilisateur(@PathVariable("id") Long idUtilisateur, @RequestBody ModificationUtilisateurParUtilisateurDto modificationUtilisateurParUtilisateurDto) {
        utilisateurService.modifierUtilisateurParUtilisateur(idUtilisateur, modificationUtilisateurParUtilisateurDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(CHANGE_MDP)
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        parametreService.changePassword(changePasswordDto);
        return ResponseEntity.ok(MDP_BIEN_MIS_A_JOUR);
    }


    //    Parametre Admin
    @PostMapping(INSCRIRE_UTILISATEUR)
    public ResponseEntity<?> inscrireUtilisateur(@RequestBody InscriptionDto inscriptionDto) {
        utilisateurService.inscrireUtilisateur(inscriptionDto);
        return ResponseEntity.ok().build();
    }


    @PatchMapping(MODIFIER_UTILISATEUR_ADMIN + ID)
    public ResponseEntity<?> modifierUtilisateurParAdmin(@PathVariable("id") Long idUtilisateur, @RequestBody ModificationUtilisateurParAdminDto modificationUtilisateurParAdminDto) {
        utilisateurService.modifierUtilisateurParAdmin(idUtilisateur, modificationUtilisateurParAdminDto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(MODIFIER_EST_ADMIN + ID)
    public ResponseEntity<?> modifierEstAdmin(@PathVariable("id") Long idUtilisateur, @RequestBody boolean estAdmin) {
        utilisateurService.modifierEstAdmin(idUtilisateur, estAdmin);
        return ResponseEntity.ok().build();
    }

    //Parametre Super Admin
    @PostMapping(CREER_ENTITE)
    public ResponseEntity<?> creerEntite(CreationEntiteDto creationEntiteDto) {
        parametreService.ajouterEntite(creationEntiteDto);
        return ResponseEntity.ok().build();
    }

    //Initialisation
    @GetMapping(UTILISATEUR_ENTITE + ID)
    public ResponseEntity<?> getAllUtilisateurParEntiteId(@PathVariable("id") Long idEntite) {
        return ResponseEntity.ok(parametreService.getAllUtilisateurParEntiteId(idEntite));
    }
    


}
