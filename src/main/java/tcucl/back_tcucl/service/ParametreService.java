package tcucl.back_tcucl.service;

import tcucl.back_tcucl.dto.*;

import java.util.List;

public interface ParametreService {

    void changePassword(ChangePasswordDto requete);

    void modifierUtilisateurParUtilisateur(Long id, ModificationUtilisateurParUtilisateurDto modificationUtilisateurParUtilisateurDto);

    void inscrireUtilisateur(InscriptionDto inscriptionDto);

    void modifierUtilisateurParAdmin(Long id, ModificationUtilisateurParAdminDto modificationUtilisateurParAdminDto);

    void modifierEstAdmin(Long id, Boolean estAdmin);

    void supprimerUtilisateur(Long id);

    void creerEntiteEtAdmin(CreationEntiteEtAdminDto creationEntiteEtAdminDto);

    void ajouterAnneeEntite(Long entiteId, Integer anneeUniversitaire);

    List<UtilisateurDto> getAllUtilisateurParEntiteId(Long entiteId);
}
