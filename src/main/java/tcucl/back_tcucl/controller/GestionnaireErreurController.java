package tcucl.back_tcucl.controller;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ConstraintViolation;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tcucl.back_tcucl.exceptionPersonnalisee.*;

import java.util.stream.Collectors;

import static tcucl.back_tcucl.Constante.*;

@RestControllerAdvice
public class GestionnaireErreurController {

    //Entité / Utilisateur / Onglet / Element (onglet contenant une liste d'éléments)
    @ExceptionHandler(NonTrouveGeneralCustomException.class)
    public ResponseEntity<String> handleNonTrouveCustomException(NonTrouveGeneralCustomException ex) {
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

    // Ajout d'un voyage vers une destination déjà existante
    // (ce n'est pas censé arriver car usage d'un patch dasn ce cas)
    @ExceptionHandler(VoyageDejaExistantException.class)
    public ResponseEntity<String> handleEntiteDejaExistantAvecNomTypeException(VoyageDejaExistantException ex) {
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

    //Validation de Donnée custom (évite une erreur "JPA Transaction" lors d'un save)
    @ExceptionHandler(ValidationCustomException.class)
    public ResponseEntity<String> handleConstraintViolationException(ValidationCustomException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    //Tout le reste
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        // devTodo  à changer en prod afin de ne pas afficher les messages d'erreurs
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERREUR_INTERNE);
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());

    }
}
