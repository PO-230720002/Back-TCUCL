package tcucl.back_tcucl.service;

import org.springframework.security.core.Authentication;
import tcucl.back_tcucl.dto.ChangePasswordDto;
import tcucl.back_tcucl.dto.InscriptionDto;
import tcucl.back_tcucl.dto.ModificationUtilisateurParAdminDto;

public interface PermissionService {


    boolean utilisateurPeutModifierUtilisateur(Authentication authentication, Long UtilisateurId);

    boolean utlisateurOuAdminPeutChangerMdp(Authentication authentication, ChangePasswordDto changePasswordDto);

    boolean adminPeutInscrireUtilisateur(Authentication authentication, InscriptionDto inscriptionDto);

    boolean adminPeutModifierUtilisateur(Authentication authentication, ModificationUtilisateurParAdminDto modificationUtilisateurParAdminDto);

    boolean adminPeutModifierEstAdmin(Authentication authentication, Long id);

    boolean adminPeutAccéderAEntite(Authentication authentication, Long idEntite);
}
