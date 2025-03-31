package tcucl.back_tcucl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.dto.ChangePasswordDto;
import tcucl.back_tcucl.dto.ConnexionDto;
import tcucl.back_tcucl.dto.InscriptionDto;
import tcucl.back_tcucl.service.AuthentificationService;

import static tcucl.back_tcucl.Constante.*;

@RestController
@RequestMapping(AUTH)
public class AuthController {

    Logger logger = LoggerFactory.getLogger(AuthController.class);

   private final AuthentificationService authentificationService;

    public AuthController(AuthentificationService authentificationService){
        this.authentificationService = authentificationService;
    }

    @PostMapping(INSCRIPTION)
    public ResponseEntity<?> inscription(@RequestBody InscriptionDto inscriptionDto) {
        return authentificationService.inscription(inscriptionDto);
    }

    @PostMapping(INSCRIPTION2)
    public ResponseEntity<?> inscription2(@RequestBody InscriptionDto inscriptionDto) {
        return authentificationService.inscription(inscriptionDto);
    }

    @PostMapping(CONNEXION)
    public ResponseEntity<?> connexion(@RequestBody ConnexionDto connexionDto) {
        return authentificationService.connexion(connexionDto);
    }

    @PostMapping(CHANGE_MDP)
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        return authentificationService.changePassword(changePasswordDto);
    }


}

