package tcucl.back_tcucl.manager.impl.onglet;

import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.general.GeneralOngletDto;
import tcucl.back_tcucl.entity.onglet.GeneralOnglet;
import tcucl.back_tcucl.exceptionPersonnalisee.OngletNonTrouveIdException;
import tcucl.back_tcucl.manager.GeneralOngletManager;
import tcucl.back_tcucl.repository.onglet.GeneralOngletRepository;

@Component
public class GeneralOngletManagerImpl implements GeneralOngletManager {
    
    private final GeneralOngletRepository generalOngletRepository;

    public GeneralOngletManagerImpl(GeneralOngletRepository generalOngletRepository) {
        this.generalOngletRepository = generalOngletRepository;
    }

    @Override
    public GeneralOnglet getGeneralOngletById(Long ongletId) {
        return generalOngletRepository.findById(ongletId).orElseThrow(() -> new OngletNonTrouveIdException("General",ongletId));
    }

    @Override
    public void updateGeneralOngletPartiel(Long ongletId, GeneralOngletDto generalOngletDto) {
        GeneralOnglet onglet = getGeneralOngletById(ongletId);

        if (generalOngletDto.getNote() != null) {
            onglet.setNote(generalOngletDto.getNote());
        }

        if (generalOngletDto.getEstTermine() != null) {
            onglet.setEstTermine(generalOngletDto.getEstTermine());
        }

        if (generalOngletDto.getNbSalarie() != null) {
            onglet.setNbSalarie(generalOngletDto.getNbSalarie());
        }

        if (generalOngletDto.getNbEtudiant() != null) {
            onglet.setNbEtudiant(generalOngletDto.getNbEtudiant());
        }

        generalOngletRepository.save(onglet);
    }

}
