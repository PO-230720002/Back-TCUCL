package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.dto.securite.UtilisateurSecuriteDto;
import tcucl.back_tcucl.entity.Utilisateur;

import java.util.List;

public interface UtilisateurManager {

    void supprimerUtilisateur(Long id);

    List<Utilisateur> getAllUtilisateurParEntiteId(Long entiteId);

    boolean emailDejaPris(String email);

    Utilisateur save(Utilisateur utilisateur);

    Utilisateur getUtilisateurParId(Long id);

    Utilisateur getUtilisateurParEmail(String email);

    UtilisateurSecuriteDto findUtilisateurSecurityDTOByEmail(String email);
}
