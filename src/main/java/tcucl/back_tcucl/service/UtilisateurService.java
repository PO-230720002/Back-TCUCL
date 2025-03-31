package tcucl.back_tcucl.service;


import org.springframework.http.ResponseEntity;
import tcucl.back_tcucl.dto.ChangePasswordDto;
import tcucl.back_tcucl.dto.InscriptionDto;
import tcucl.back_tcucl.dto.ModificationUtilisateurParAdminDto;
import tcucl.back_tcucl.dto.ModificationUtilisateurParUtilisateurDto;
import tcucl.back_tcucl.entity.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    ResponseEntity<?> modifierEstAdmin(Long id, Boolean estAdmin);

    ResponseEntity<?> changePassword(ChangePasswordDto requete);

    ResponseEntity<?> save(Utilisateur utilisateur);

    ResponseEntity<?> modifierUtilisateurParUtilisateur(Long id, ModificationUtilisateurParUtilisateurDto modificationUtilisateurParUtilisateurDto);

    ResponseEntity<?> modifierUtilisateurParAdmin(Long id, ModificationUtilisateurParAdminDto modificationUtilisateurParAdminDto);

    ResponseEntity<?> inscrireUtilisateur(InscriptionDto inscriptionDto);

    Utilisateur getUtilisateurParEmail(String email);

    Utilisateur getUtilisateurParId(Long id);

    Boolean emailDejaPris(String email);


    List<Utilisateur> getAllUtilisateurParEntiteId(Long entiteId);

}
