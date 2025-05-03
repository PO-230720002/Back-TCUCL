package tcucl.back_tcucl.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tcucl.back_tcucl.exceptionPersonnalisee.*;

import static tcucl.back_tcucl.Constante.*;

@RestControllerAdvice
public class GestionnaireErreurController {

    //Entité / Utilisateur / Onglet
    // Todo les objets dépendant d'un onglet
    @ExceptionHandler(NonTrouveCustomException.class)
    public ResponseEntity<String> handleNonTrouveCustomException(NonTrouveCustomException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    //Inscription
    @ExceptionHandler(EmailDejaPrisException.class)
    public ResponseEntity<String> handleEmailDejaPrisException(EmailDejaPrisException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(EntiteDejaExistantAvecNomTypeException.class)
    public ResponseEntity<String> handleEntiteDejaExistantAvecNomTypeException(EntiteDejaExistantAvecNomTypeException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    //Changement de mot de passe
    @ExceptionHandler(MauvaisAncienMdpException.class)
    public ResponseEntity<String> handleMauvaisAncienMdpException(MauvaisAncienMdpException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    //Connexion
    @ExceptionHandler(MauvaisIdentifiantsException.class)
    public ResponseEntity<String> handleMauvaisIdentifiantException(MauvaisIdentifiantsException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ERREUR_AUTHENTIFICATION);
    }

    //Tout le reste
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        // TODO  à changer en prod afin de ne pas afficher les messages d'erreurs
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERREUR_INTERNE);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());

    }
}
