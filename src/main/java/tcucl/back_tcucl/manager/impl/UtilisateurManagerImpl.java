package tcucl.back_tcucl.manager.impl;

import tcucl.back_tcucl.manager.UtilisateurManager;
import org.springframework.stereotype.Service;
import tcucl.back_tcucl.entity.Utilisateur;
import tcucl.back_tcucl.exceptionPersonnalisee.UtilisateurNonTrouveIdException;
import tcucl.back_tcucl.exceptionPersonnalisee.UtilisateurNonTrouveEmailException;
import tcucl.back_tcucl.repository.UtilisateurRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UtilisateurManagerImpl implements UtilisateurManager {

    UtilisateurRepository utilisateurRepository;

    public UtilisateurManagerImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public Utilisateur getUtilisateurParId(Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if(utilisateur.isEmpty()){
            throw new UtilisateurNonTrouveIdException(id);
        }
        return utilisateur.get();
    }

    @Override
    public Utilisateur getUtilisateurParEmail(String email) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmail(email);
        if(utilisateur.isEmpty()){
            throw new UtilisateurNonTrouveEmailException(email);
        }
        return utilisateur.get();
    }

    @Override
    public List<Utilisateur> getAllUtilisateurParEntiteId(Long entiteId) {
        return utilisateurRepository.findAllByEntiteId(entiteId);
    }

    @Override
    public boolean emailDejaPris(String email){
        return utilisateurRepository.existsUtilisateurByEmail(email);
    }

    @Override
    public Utilisateur save(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }
}
