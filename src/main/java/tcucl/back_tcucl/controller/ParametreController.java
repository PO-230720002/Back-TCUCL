package tcucl.back_tcucl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tcucl.back_tcucl.dto.*;
import tcucl.back_tcucl.entity.Utilisateur;
import tcucl.back_tcucl.service.FacteurEmissionService;
import tcucl.back_tcucl.service.ParametreService;

import java.util.List;

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
    @PreAuthorize("hasRole('ROLE_UTILISATEUR_' + #utilisateurId)")
    @PatchMapping(REST_MODIFIER_UTILISATEUR_UTILISATEUR + REST_UTILISATEUR_ID)
    public ResponseEntity<?> modifierUtilisateurParUtilisateur(@PathVariable("utilisateurId") Long utilisateurId, @RequestBody ModificationUtilisateurParUtilisateurDto modificationUtilisateurParUtilisateurDto) {
        parametreService.modifierUtilisateurParUtilisateur(utilisateurId, modificationUtilisateurParUtilisateurDto);
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
    @PatchMapping(REST_MODIFIER_UTILISATEUR_ADMIN + REST_UTILISATEUR_ID)
    public ResponseEntity<?> modifierUtilisateurParAdmin(@PathVariable("utilisateurId") Long utilisateurId, @RequestBody ModificationUtilisateurParAdminDto modificationUtilisateurParAdminDto) {
        parametreService.modifierUtilisateurParAdmin(utilisateurId, modificationUtilisateurParAdminDto);
        return ResponseEntity.ok(REST_MESSAGE_UTILISATEUR_MODIFIE);
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN') or (hasRole('ROLE_ADMIN') and @permissionService.adminPeutModifierEstAdmin(authentication, #utilisateurId))")
    @PatchMapping(REST_MODIFIER_EST_ADMIN + REST_UTILISATEUR_ID)
    public ResponseEntity<?> modifierEstAdmin(@PathVariable("utilisateurId") Long utilisateurId, @RequestBody boolean estAdmin) {
        parametreService.modifierEstAdmin(utilisateurId, estAdmin);
        return ResponseEntity.ok(REST_MESSAGE_CHANGE_STATUT_ADMIN);
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN') or (hasRole('ROLE_ADMIN') and @permissionService.adminPeutSupprimerUtilisateur(authentication, #utilisateurId))")
    @DeleteMapping(REST_SUPPRIMER_UTILISATEUR + REST_UTILISATEUR_ID)
    public ResponseEntity<?> supprimerUtilisateur(@PathVariable("utilisateurId") Long utilisateurId) {
        parametreService.supprimerUtilisateur(utilisateurId);
        return ResponseEntity.ok(REST_MESSAGE_UTILISATEUR_SUPPRIME);
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN') or (hasRole('ROLE_ADMIN') and @permissionService.adminPeutAjouterAnneeEntite(authentication, #entiteId))")
    @PostMapping(REST_AJOUTER_ANNEE + REST_ENTITE_ID)
    public ResponseEntity<?> ajouterAnneeEntite(@PathVariable("entiteId") Long entiteId, @RequestBody Integer anneeDto) {
        parametreService.ajouterAnneeEntite(entiteId, anneeDto);
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
    public ResponseEntity<?> importFacteurEmissionFromExcel(@RequestParam("file") MultipartFile file) {
        facteurEmissionService.importFacteurEmissionFromExcel(file);
        return ResponseEntity.ok(REST_MESSAGE_IMPORT_FACTEURS_EMISSION);
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping(REST_CREER_ANNEE_SUIVANTE)
    public ResponseEntity<?> creerAnneeSuivante() {
        parametreService.creerAnneeSuivante();
        return ResponseEntity.ok(REST_MESSAGE_ANNEE_SUIVANTE_CREEE);
    }

    //Initialisation
    @PreAuthorize("hasRole('ROLE_SUPERADMIN') or (hasRole('ROLE_ENTITE_' + #entiteId))")
    @GetMapping(REST_UTILISATEUR_ENTITE + REST_ENTITE_ID)
    public ResponseEntity<?> getAllUtilisateurParEntiteId(@PathVariable("entiteId") Long entiteId) {
        List<Utilisateur> allUtilisateurParEntiteId = parametreService.getAllUtilisateurParEntiteId(entiteId);
        List<UtilisateurDto> allUtilisateurParEntiteIdDto = allUtilisateurParEntiteId.stream().map(UtilisateurDto::new).toList();
        return ResponseEntity.ok(allUtilisateurParEntiteIdDto);
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping()
    public ResponseEntity<?> peutCreerUneNouvelleAnnee() {
        return ResponseEntity.ok(parametreService.peutCreerUneNouvelleAnnee());
    }

}
