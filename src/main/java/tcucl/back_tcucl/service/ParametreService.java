package tcucl.back_tcucl.service;

import org.springframework.http.ResponseEntity;
import tcucl.back_tcucl.dto.ChangePasswordDto;
import tcucl.back_tcucl.dto.CreationEntiteDto;

public interface ParametreService {

    ResponseEntity<?> changePassword(ChangePasswordDto requete);

    void ajouterEntite(CreationEntiteDto creationEntiteDto);
}
