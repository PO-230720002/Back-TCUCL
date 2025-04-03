package tcucl.back_tcucl.service;

import tcucl.back_tcucl.dto.ChangePasswordDto;
import tcucl.back_tcucl.dto.CreationEntiteDto;
import tcucl.back_tcucl.dto.UtilisateurDto;

import java.util.List;

public interface ParametreService {

    void changePassword(ChangePasswordDto requete);

    void ajouterEntite(CreationEntiteDto creationEntiteDto);

    List<UtilisateurDto> getAllUtilisateurParEntiteId(Long entiteId);
}
