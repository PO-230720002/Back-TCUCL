package tcucl.back_tcucl.service;

import org.springframework.http.ResponseEntity;
import tcucl.back_tcucl.dto.ChangePasswordDto;
import tcucl.back_tcucl.dto.ConnexionDto;
import tcucl.back_tcucl.dto.InscriptionDto;

public interface AuthentificationService {
    ResponseEntity<?> inscription(InscriptionDto inscriptionDto);

    ResponseEntity<?> changePassword(ChangePasswordDto requete);

    ResponseEntity<?> connexion(ConnexionDto connexionDto);
}
