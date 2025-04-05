package tcucl.back_tcucl.service;

import tcucl.back_tcucl.dto.ChangePasswordDto;
import tcucl.back_tcucl.dto.CreationEntiteEtAdminDto;
import tcucl.back_tcucl.dto.UtilisateurDto;

import java.util.List;

public interface ParametreService {

    void changePassword(ChangePasswordDto requete);

    void creerEntiteEtAdmin(CreationEntiteEtAdminDto creationEntiteEtAdminDto);

    List<UtilisateurDto> getAllUtilisateurParEntiteId(Long entiteId);
}
