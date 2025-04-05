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


    @ExceptionHandler(EmailDejaPrisException.class)
    public ResponseEntity<String> handleEmailDejaPrisException(EmailDejaPrisException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(UtilisateurNonTrouveEmailException.class)
    public ResponseEntity<String> handleUtilisateurNonTrouveEmailException(UtilisateurNonTrouveEmailException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ERREUR_UTILISATEUR_NON_TROUVE);
    }

    @ExceptionHandler(UtilisateurNonTrouveIdException.class)
    public ResponseEntity<String> handleUtilisateurNonTrouveIdException(UtilisateurNonTrouveIdException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ERREUR_UTILISATEUR_NON_TROUVE);
    }

    //Connexion
    @ExceptionHandler(MauvaisAncienMdpException.class)
    public ResponseEntity<String> handleMauvaisAncienMdpException(MauvaisAncienMdpException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ERREUR_MAUVAIS_ANCIEN_MDP);
    }

    //Connexion
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ERREUR_AUTHENTIFICATION);
    }

    @ExceptionHandler(EntiteNonTrouveeIdException.class)
    public ResponseEntity<String> handleEntiteNonTrouveeException(EntiteNonTrouveeIdException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ERREUR_ENTITE_NON_TROUVE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERREUR_INTERNE);
    }
}
