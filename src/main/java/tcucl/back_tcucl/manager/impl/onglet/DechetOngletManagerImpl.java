package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.dechet.DechetDto;
import tcucl.back_tcucl.dto.onglet.dechet.DechetOngletDto;
import tcucl.back_tcucl.entity.onglet.DechetOnglet;
import tcucl.back_tcucl.entity.parametre.dechet.Dechet;
import tcucl.back_tcucl.manager.DechetOngletManager;
import tcucl.back_tcucl.repository.onglet.DechetOngletRepository;

@Component
public class DechetOngletManagerImpl implements DechetOngletManager {

    private final DechetOngletRepository dechetOngletRepository;

    public DechetOngletManagerImpl(DechetOngletRepository dechetOngletRepository) {
        this.dechetOngletRepository = dechetOngletRepository;
    }

    @Override
    public DechetOnglet getDechetOngletById(Long id) {
        return dechetOngletRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("DechetOnglet non trouvé avec l'Id: " + id));
    }

    @Override
    public void updateDechetOngletPartiel(Long id, DechetOngletDto dto) {
        DechetOnglet onglet = getDechetOngletById(id);

        if (dto.getEstTermine() != null) {
            onglet.setEstTermine(dto.getEstTermine());
        }
        if (dto.getNote() != null) {
            onglet.setNote(dto.getNote());
        }

        // Ordures ménagères
        if (dto.getOrdures_menageres() != null) {
            Dechet ordures = onglet.getOrdures_menageres();
            if (ordures == null) {
                ordures = new Dechet();
                onglet.setOrdures_menageres(ordures);
            }
            DechetDto orduresDto = dto.getOrdures_menageres();
            if (orduresDto.getTraitement() != null)
                ordures.setTraitement(orduresDto.getTraitement());
            if (orduresDto.getQuantiteTonne() != null)
                ordures.setQuantiteTonne(orduresDto.getQuantiteTonne());
        }

        // Cartons
        if (dto.getCartons() != null) {
            Dechet cartons = onglet.getCartons();
            if (cartons == null) {
                cartons = new Dechet();
                onglet.setCartons(cartons);
            }
            DechetDto cartonsDto = dto.getCartons();
            if (cartonsDto.getTraitement() != null)
                cartons.setTraitement(cartonsDto.getTraitement());
            if (cartonsDto.getQuantiteTonne() != null)
                cartons.setQuantiteTonne(cartonsDto.getQuantiteTonne());
        }

        // Verre
        if (dto.getVerre() != null) {
            Dechet verre = onglet.getVerre();
            if (verre == null) {
                verre = new Dechet();
                onglet.setVerre(verre);
            }
            DechetDto verreDto = dto.getVerre();
            if (verreDto.getTraitement() != null)
                verre.setTraitement(verreDto.getTraitement());
            if (verreDto.getQuantiteTonne() != null)
                verre.setQuantiteTonne(verreDto.getQuantiteTonne());
        }

        // Métaux
        if (dto.getMetaux() != null) {
            Dechet metaux = onglet.getMetaux();
            if (metaux == null) {
                metaux = new Dechet();
                onglet.setMetaux(metaux);
            }
            DechetDto metauxDto = dto.getMetaux();
            if (metauxDto.getTraitement() != null)
                metaux.setTraitement(metauxDto.getTraitement());
            if (metauxDto.getQuantiteTonne() != null)
                metaux.setQuantiteTonne(metauxDto.getQuantiteTonne());
        }

        // Textile
        if (dto.getTextile() != null) {
            Dechet textile = onglet.getTextile();
            if (textile == null) {
                textile = new Dechet();
                onglet.setTextile(textile);
            }
            DechetDto textileDto = dto.getTextile();
            if (textileDto.getTraitement() != null)
                textile.setTraitement(textileDto.getTraitement());
            if (textileDto.getQuantiteTonne() != null)
                textile.setQuantiteTonne(textileDto.getQuantiteTonne());
        }

        dechetOngletRepository.save(onglet);
    }

}
