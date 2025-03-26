package tcucl.back_tcucl.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tcucl.back_tcucl.entity.onglet.EnergieOnglet;
import tcucl.back_tcucl.repository.onglet.EnergieOngletRepository;
import tcucl.back_tcucl.service.EnergieOngletService;

@Service
public class EnergieOngletServiceImpl implements EnergieOngletService {

    private final EnergieOngletRepository energieOngletRepository;


    public EnergieOngletServiceImpl(EnergieOngletRepository energieOngletRepository) {
        this.energieOngletRepository = energieOngletRepository;
    }

    @Transactional
    public EnergieOnglet create(EnergieOnglet energieOnglet) {
        return energieOngletRepository.save(energieOnglet);
    }

    @Transactional
    public EnergieOnglet getEnergieOngletById(Long id) {
        return energieOngletRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("EnergieOnglet non trouvé avec l'ID : " + id));
    }

    @Override
    public EnergieOnglet updateEnergieOnglet(EnergieOnglet energieOnglet) {
        return energieOngletRepository.save(energieOnglet);
    }

    @Transactional
    public void setEstTermine(Long id, boolean estTermine) {
        int updated = energieOngletRepository.updateEstTermine(id, estTermine);
        if (updated == 0) {
            throw new EntityNotFoundException("EnergieOnglet non trouvé avec l'ID : " + id);
        }
    }

    @Transactional
    public void setConsoGaz(Long id, Float consoGaz) {
        int updated = energieOngletRepository.updateConsoGaz(id, consoGaz);
        if (updated == 0) {
            throw new EntityNotFoundException("EnergieOnglet non trouvé avec l'ID : " + id);
        }
    }
    
    @Transactional
    public void setConsoFioul(Long id, Float consoFioul) {
        int updated = energieOngletRepository.updateConsoFioul(id, consoFioul);
        if (updated == 0) {
            throw new EntityNotFoundException("EnergieOnglet non trouvé avec l'ID : " + id);
        }
    }

    @Transactional
    public void setConsoBois(Long id, Float consoBois) {
        int updated = energieOngletRepository.updateConsoBois(id, consoBois);
        if (updated == 0) {
            throw new EntityNotFoundException("EnergieOnglet non trouvé avec l'ID : " + id);
        }
    }

    @Transactional
    public void setConsoReseauVille(Long id, Float consoReseauVille) {
        int updated = energieOngletRepository.updateConsoReseauVille(id, consoReseauVille);
        if (updated == 0) {
            throw new EntityNotFoundException("EnergieOnglet non trouvé avec l'ID : " + id);
        }
    }

    @Transactional
    public void setConsoElecChauffage(Long id, Float consoElecChauffage) {
        int updated = energieOngletRepository.updateConsoElecChauffage(id, consoElecChauffage);
        if (updated == 0) {
            throw new EntityNotFoundException("EnergieOnglet non trouvé avec l'ID : " + id);
        }
    }

    @Transactional
    public void setConsoElecSpecifique(Long id, Float consoElecSpecifique) {
        int updated = energieOngletRepository.updateConsoElecSpecifique(id, consoElecSpecifique);
        if (updated == 0) {
            throw new EntityNotFoundException("EnergieOnglet non trouvé avec l'ID : " + id);
        }
    }

    @Transactional
    public void setConsoEau(Long id, Float consoEau) {
        int updated = energieOngletRepository.updateConsoEau(id, consoEau);
        if (updated == 0) {
            throw new EntityNotFoundException("EnergieOnglet non trouvé avec l'ID : " + id);
        }
    }

    @Transactional
    public void setNote(Long id, String note) {
        int updated = energieOngletRepository.updateNote(id, note);
        if (updated == 0) {
            throw new EntityNotFoundException("EnergieOnglet non trouvé avec l'ID : " + id);
        }
    }
}
