package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.general.GeneralOngletDto;
import tcucl.back_tcucl.entity.onglet.GeneralOnglet;
import tcucl.back_tcucl.manager.GeneralOngletManager;
import tcucl.back_tcucl.repository.onglet.GeneralOngletRepository;

@Component
public class GeneralOngletManagerImpl implements GeneralOngletManager {
    
    private final GeneralOngletRepository generalOngletRepository;

    public GeneralOngletManagerImpl(GeneralOngletRepository generalOngletRepository) {
        this.generalOngletRepository = generalOngletRepository;
    }

    @Override
    public GeneralOnglet getGeneralOngletById(Long id) {
        return generalOngletRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("GeneralOnglet non trouvé avec l'Id: " + id));
    }

    @Override
    public void updateGeneralOngletPartiel(Long id, GeneralOngletDto dto) {
        GeneralOnglet onglet = getGeneralOngletById(id);

        if (dto.getNote() != null) {
            onglet.setNote(dto.getNote());
        }

        if (dto.getEstTermine() != null) {
            onglet.setEstTermine(dto.getEstTermine());
        }

        if (dto.getNbSalarie() != null) {
            onglet.setNbSalarie(dto.getNbSalarie());
        }

        if (dto.getNbEtudiant() != null) {
            onglet.setNbEtudiant(dto.getNbEtudiant());
        }

        generalOngletRepository.save(onglet);
    }

}
