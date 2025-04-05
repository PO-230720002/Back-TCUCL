package tcucl.back_tcucl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.dto.*;
import tcucl.back_tcucl.service.ParametreService;
import tcucl.back_tcucl.service.UtilisateurService;
import tcucl.back_tcucl.service.impl.PermissionServiceImpl;

import static tcucl.back_tcucl.Constante.*;

@RestController
@RequestMapping(PARAMETRE)
public class ParametreController {

    private final UtilisateurService utilisateurService;
    private final ParametreService parametreService;
    private final PermissionServiceImpl permissionService;

    public ParametreController(UtilisateurService utilisateurService, ParametreService parametreService, PermissionServiceImpl permissionService) {
        this.utilisateurService = utilisateurService;
        this.parametreService = parametreService;
        this.permissionService = permissionService;
    }

    //    Parametre perso
    @PreAuthorize("@permissionService.utilisateurPeutModifierUtilisateur(authentication, #idUtilisateur)")
    @PatchMapping(MODIFIER_UTILISATEUR_UTILISATEUR + ID)
    public ResponseEntity<?> modifierUtilisateurParUtilisateur(@PathVariable("id") Long idUtilisateur, @RequestBody ModificationUtilisateurParUtilisateurDto modificationUtilisateurParUtilisateurDto) {
        utilisateurService.modifierUtilisateurParUtilisateur(idUtilisateur, modificationUtilisateurParUtilisateurDto);
        return ResponseEntity.ok().build();
    }


    @PreAuthorize("@permissionService.utlisateurOuAdminPeutChangerMdp(authentication, #changePasswordDto)")
    @PostMapping(CHANGE_MDP)
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        parametreService.changePassword(changePasswordDto);
        return ResponseEntity.ok(MDP_BIEN_MIS_A_JOUR);
    }

    //    Parametre Admin
    @PreAuthorize("hasRole('ROLE_SUPERADMIN') or (hasRole('ROLE_ADMIN') and @permissionService.adminPeutInscrireUtilisateur(authentication, #inscriptionDto))")
    @PostMapping(INSCRIRE_UTILISATEUR)
    public ResponseEntity<?> inscrireUtilisateur(@RequestBody InscriptionDto inscriptionDto) {
        utilisateurService.inscrireUtilisateur(inscriptionDto);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN') or (hasRole('ROLE_ADMIN') and @permissionService.adminPeutModifierUtilisateur(authentication, modificationUtilisateurParAdminDto))")
    @PatchMapping(MODIFIER_UTILISATEUR_ADMIN + ID)
    public ResponseEntity<?> modifierUtilisateurParAdmin(@PathVariable("id") Long idUtilisateur, @RequestBody ModificationUtilisateurParAdminDto modificationUtilisateurParAdminDto) {
        utilisateurService.modifierUtilisateurParAdmin(idUtilisateur, modificationUtilisateurParAdminDto);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN') or (hasRole('ROLE_ADMIN') and @permissionService.adminPeutModifierEstAdmin(authentication, #idUtilisateur))")
    @PatchMapping(MODIFIER_EST_ADMIN + ID)
    public ResponseEntity<?> modifierEstAdmin(@PathVariable("id") Long idUtilisateur, @RequestBody boolean estAdmin) {
        utilisateurService.modifierEstAdmin(idUtilisateur, estAdmin);
        return ResponseEntity.ok().build();
    }

    //Parametre Super Admin
    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @PostMapping(CREER_ENTITE)
    public ResponseEntity<?> creerEntite(CreationEntiteEtAdminDto creationEntiteEtAdminDto) {
        parametreService.creerEntiteEtAdmin(creationEntiteEtAdminDto);
        return ResponseEntity.ok().build();
    }

    //Initialisation
    @PreAuthorize("hasRole('ROLE_SUPERADMIN') or (hasRole('ROLE_ADMIN') and @permissionService.adminPeutAccéderAEntite(authentication, #idEntite))")
    @GetMapping(UTILISATEUR_ENTITE + ID)
    public ResponseEntity<?> getAllUtilisateurParEntiteId(@PathVariable("id") Long idEntite) {
        return ResponseEntity.ok(parametreService.getAllUtilisateurParEntiteId(idEntite));
    }



}
