package tcucl.back_tcucl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tcucl.back_tcucl.dto.*;
import tcucl.back_tcucl.service.FacteurEmissionService;
import tcucl.back_tcucl.service.ParametreService;

import static tcucl.back_tcucl.controller.ControllerConstante.*;

@RestController
@RequestMapping(REST_PARAMETRE)
public class ParametreController {

    private final ParametreService parametreService;
    private final FacteurEmissionService facteurEmissionService;

    public ParametreController(ParametreService parametreService, FacteurEmissionService facteurEmissionService) {
        this.parametreService = parametreService;
        this.facteurEmissionService = facteurEmissionService;
    }

    //    Parametre perso
    @PreAuthorize("@permissionService.utilisateurPeutModifierUtilisateur(authentication, #idUtilisateur)")
    @PatchMapping(REST_MODIFIER_UTILISATEUR_UTILISATEUR + REST_ID)
    public ResponseEntity<?> modifierUtilisateurParUtilisateur(@PathVariable("id") Long idUtilisateur, @RequestBody ModificationUtilisateurParUtilisateurDto modificationUtilisateurParUtilisateurDto) {
        parametreService.modifierUtilisateurParUtilisateur(idUtilisateur, modificationUtilisateurParUtilisateurDto);
        return ResponseEntity.ok(REST_MESSAGE_UTILISATEUR_MODIFIE);
    }


    @PreAuthorize("@permissionService.utlisateurOuAdminPeutChangerMdp(authentication, #changePasswordDto)")
    @PostMapping(REST_CHANGE_MDP)
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        parametreService.changePassword(changePasswordDto);
        return ResponseEntity.ok(REST_MESSAGE_MDP_BIEN_MIS_A_JOUR);
    }

    //    Parametre Admin
    @PreAuthorize("hasRole('ROLE_SUPERADMIN') or (hasRole('ROLE_ADMIN') and @permissionService.adminPeutInscrireUtilisateur(authentication, #inscriptionDto))")
    @PostMapping(REST_INSCRIRE_UTILISATEUR)
    public ResponseEntity<?> inscrireUtilisateur(@RequestBody InscriptionDto inscriptionDto) {
        parametreService.inscrireUtilisateur(inscriptionDto);
        return ResponseEntity.ok(REST_MESSAGE_UTILISATEUR_BIEN_INSCRIT);
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN') or (hasRole('ROLE_ADMIN') and @permissionService.adminPeutModifierUtilisateur(authentication, modificationUtilisateurParAdminDto))")
    @PatchMapping(REST_MODIFIER_UTILISATEUR_ADMIN + REST_ID)
    public ResponseEntity<?> modifierUtilisateurParAdmin(@PathVariable("id") Long idUtilisateur, @RequestBody ModificationUtilisateurParAdminDto modificationUtilisateurParAdminDto) {
        parametreService.modifierUtilisateurParAdmin(idUtilisateur, modificationUtilisateurParAdminDto);
        return ResponseEntity.ok(REST_MESSAGE_UTILISATEUR_MODIFIE);
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN') or (hasRole('ROLE_ADMIN') and @permissionService.adminPeutModifierEstAdmin(authentication, #idUtilisateur))")
    @PatchMapping(REST_MODIFIER_EST_ADMIN + REST_ID)
    public ResponseEntity<?> modifierEstAdmin(@PathVariable("id") Long idUtilisateur, @RequestBody boolean estAdmin) {
        parametreService.modifierEstAdmin(idUtilisateur, estAdmin);
        return ResponseEntity.ok(REST_MESSAGE_CHANGE_STATUT_ADMIN);
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN') or (hasRole('ROLE_ADMIN') and @permissionService.adminPeutSupprimerUtilisateur(authentication, #idUtilisateur))")
    @DeleteMapping(REST_SUPPRIMER_UTILISATEUR + REST_ID)
    public ResponseEntity<?> supprimerUtilisateur(@PathVariable("id") Long idUtilisateur) {
        parametreService.supprimerUtilisateur(idUtilisateur);
        return ResponseEntity.ok(REST_MESSAGE_UTILISATEUR_SUPPRIME);
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN') or (hasRole('ROLE_ADMIN') and @permissionService.adminPeutAjouterAnneeEntite(authentication, #idEntite))")
    public ResponseEntity<?> ajouterAnneeEntite(@PathVariable("id") Long idEntite, @RequestBody Integer anneeDto) {
        parametreService.ajouterAnneeEntite(idEntite, anneeDto);
        return ResponseEntity.ok(REST_MESSAGE_ANNEE_ENTITE_AJOUTEE);
    }

    //Parametre Super Admin
    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @PostMapping(REST_CREER_ENTITE)
    public ResponseEntity<?> creerEntite(@RequestBody CreationEntiteEtAdminDto creationEntiteEtAdminDto) {
        parametreService.creerEntiteEtAdmin(creationEntiteEtAdminDto);
        return ResponseEntity.ok(REST_MESSAGE_ENTITE_CREEE);
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @PostMapping(REST_IMPORT_FACTEURS_EMISSION)
    public String triggerImport(@RequestParam("file") MultipartFile file) {
        return facteurEmissionService.importFromExcel(file);
    }

    //Initialisation
    @PreAuthorize("hasRole('ROLE_SUPERADMIN') or (hasRole('ROLE_ADMIN') and @permissionService.adminPeutAccéderAEntite(authentication, #idEntite))")
//    @PreAuthorize("hasRole('ROLE_SUPERADMIN') or (hasRole('ROLE_ADMIN_' + '#idEntite')")
    @GetMapping(REST_UTILISATEUR_ENTITE + REST_ID)
    public ResponseEntity<?> getAllUtilisateurParEntiteId(@PathVariable("id") Long idEntite) {
        return ResponseEntity.ok(parametreService.getAllUtilisateurParEntiteId(idEntite));
    }

}
