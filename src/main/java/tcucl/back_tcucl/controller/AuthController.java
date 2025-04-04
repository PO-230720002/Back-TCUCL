package tcucl.back_tcucl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.dto.ChangePasswordDto;
import tcucl.back_tcucl.dto.ConnexionDto;
import tcucl.back_tcucl.dto.InscriptionDto;
import tcucl.back_tcucl.service.AuthentificationService;
//import tcucl.back_tcucl.service.PermissionService;

import static tcucl.back_tcucl.Constante.*;

@RestController
@RequestMapping(AUTH)
public class AuthController {

    Logger logger = LoggerFactory.getLogger(AuthController.class);

   private final AuthentificationService authentificationService;

    public AuthController(AuthentificationService authentificationService){
        this.authentificationService = authentificationService;
    }

    //pour les tests
    // TODO supprimer cette méthode en fin de dev
    @PostMapping(INSCRIPTION2)
    public ResponseEntity<?> inscription2(@RequestBody InscriptionDto inscriptionDto) {
        authentificationService.inscription(inscriptionDto);
        return ResponseEntity.ok(UTILISATEUR_BIEN_ENREGISTRE);
    }

    //connexion de base
    @PostMapping(CONNEXION)
    public ResponseEntity<?> connexion(@RequestBody ConnexionDto connexionDto) {
        return ResponseEntity.ok(authentificationService.connexion(connexionDto));
    }

    //processus d'inscription
    @PostMapping(CHANGE_MDP)
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        authentificationService.changePassword(changePasswordDto);
        return ResponseEntity.ok(MDP_BIEN_MIS_A_JOUR);

    }


}

