package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.dechet.DechetDto;
import tcucl.back_tcucl.dto.onglet.dechet.DechetOngletDto;
import tcucl.back_tcucl.entity.onglet.dechet.DechetOnglet;
import tcucl.back_tcucl.entity.onglet.dechet.Dechet;
import tcucl.back_tcucl.manager.DechetOngletManager;
import tcucl.back_tcucl.repository.onglet.DechetOngletRepository;

@Component
public class DechetOngletManagerImpl implements DechetOngletManager {

    private final DechetOngletRepository dechetOngletRepository;

    public DechetOngletManagerImpl(DechetOngletRepository dechetOngletRepository) {
        this.dechetOngletRepository = dechetOngletRepository;
    }

    @Override
    public DechetOnglet getDechetOngletById(Long ongletId) {
        return dechetOngletRepository.findById(ongletId).orElseThrow(() -> new EntityNotFoundException("DechetOnglet non trouvé avec l'Id: " + ongletId));
    }

    @Override
    public void updateDechetOngletPartiel(Long ongletId, DechetOngletDto dechetOngletDto) {
        DechetOnglet onglet = getDechetOngletById(ongletId);

        if (dechetOngletDto.getEstTermine() != null) {
            onglet.setEstTermine(dechetOngletDto.getEstTermine());
        }
        if (dechetOngletDto.getNote() != null) {
            onglet.setNote(dechetOngletDto.getNote());
        }

        // Ordures ménagères
        if (dechetOngletDto.getOrdures_menageres() != null) {
            Dechet ordures = onglet.getOrdures_menageres();
            if (ordures == null) {
                ordures = new Dechet();
                onglet.setOrdures_menageres(ordures);
            }
            DechetDto orduresDto = dechetOngletDto.getOrdures_menageres();
            if (orduresDto.getTraitement() != null)
                ordures.setTraitement(orduresDto.getTraitement());
            if (orduresDto.getQuantiteTonne() != null)
                ordures.setQuantiteTonne(orduresDto.getQuantiteTonne());
        }

        // Cartons
        if (dechetOngletDto.getCartons() != null) {
            Dechet cartons = onglet.getCartons();
            if (cartons == null) {
                cartons = new Dechet();
                onglet.setCartons(cartons);
            }
            DechetDto cartonsDto = dechetOngletDto.getCartons();
            if (cartonsDto.getTraitement() != null)
                cartons.setTraitement(cartonsDto.getTraitement());
            if (cartonsDto.getQuantiteTonne() != null)
                cartons.setQuantiteTonne(cartonsDto.getQuantiteTonne());
        }

        // Verre
        if (dechetOngletDto.getVerre() != null) {
            Dechet verre = onglet.getVerre();
            if (verre == null) {
                verre = new Dechet();
                onglet.setVerre(verre);
            }
            DechetDto verreDto = dechetOngletDto.getVerre();
            if (verreDto.getTraitement() != null)
                verre.setTraitement(verreDto.getTraitement());
            if (verreDto.getQuantiteTonne() != null)
                verre.setQuantiteTonne(verreDto.getQuantiteTonne());
        }

        // Métaux
        if (dechetOngletDto.getMetaux() != null) {
            Dechet metaux = onglet.getMetaux();
            if (metaux == null) {
                metaux = new Dechet();
                onglet.setMetaux(metaux);
            }
            DechetDto metauxDto = dechetOngletDto.getMetaux();
            if (metauxDto.getTraitement() != null)
                metaux.setTraitement(metauxDto.getTraitement());
            if (metauxDto.getQuantiteTonne() != null)
                metaux.setQuantiteTonne(metauxDto.getQuantiteTonne());
        }

        // Textile
        if (dechetOngletDto.getTextile() != null) {
            Dechet textile = onglet.getTextile();
            if (textile == null) {
                textile = new Dechet();
                onglet.setTextile(textile);
            }
            DechetDto textileDto = dechetOngletDto.getTextile();
            if (textileDto.getTraitement() != null)
                textile.setTraitement(textileDto.getTraitement());
            if (textileDto.getQuantiteTonne() != null)
                textile.setQuantiteTonne(textileDto.getQuantiteTonne());
        }

        dechetOngletRepository.save(onglet);
    }

}
