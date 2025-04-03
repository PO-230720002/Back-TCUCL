package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.dto.UtilisateurDto;
import tcucl.back_tcucl.entity.Utilisateur;

import java.util.List;

public interface UtilisateurManager {

    List<Utilisateur> getAllUtilisateurParEntiteId(Long entiteId);

    boolean emailDejaPris(String email);

    Utilisateur save(Utilisateur utilisateur);

    Utilisateur getUtilisateurParId(Long id);

    Utilisateur getUtilisateurParEmail(String email);
}
