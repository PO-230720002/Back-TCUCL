package tcucl.back_tcucl.manager.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.ListIdDto;
import tcucl.back_tcucl.dto.securite.AnneeSecuriteDto;
import tcucl.back_tcucl.entity.Annee;
import tcucl.back_tcucl.entity.onglet.Onglet;
import tcucl.back_tcucl.manager.AnneeManager;
import tcucl.back_tcucl.repository.AnneeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnneeManagerImpl implements AnneeManager {

    private final AnneeRepository anneeRepository;

    public AnneeManagerImpl(AnneeRepository anneeRepository) {
        this.anneeRepository = anneeRepository;
    }

    public List<AnneeSecuriteDto> findAnneesSecurityByEntiteId(Long entiteId) {
        return anneeRepository.findByEntiteId(entiteId).stream()
                .map(annee -> new AnneeSecuriteDto(
                        annee.getId(),
                        getId(annee.getAchatOnglet()),
                        getId(annee.getAutreImmobilisationOnglet()),
                        getId(annee.getAutreMobFrOnglet()),
                        getId(annee.getBatimentImmobilisationMobilierOnglet()),
                        getId(annee.getDechetOnglet()),
                        getId(annee.getEmissionFugitiveOnglet()),
                        getId(annee.getEnergieOnglet()),
                        getId(annee.getGeneralOnglet()),
                        getId(annee.getMobiliteDomicileTravailOnglet()),
                        getId(annee.getMobInternationalOnglet()),
                        getId(annee.getNumeriqueOnglet()),
                        getId(annee.getParkingVoirieOnglet()),
                        getId(annee.getVehiculeOnglet())
                ))
                .collect(Collectors.toList());
    }

    @Override
    public ListIdDto getongletIdListForEntiteAndAnnee(Long entiteId, int anneeValeur) {
        Annee annee = anneeRepository.findByEntiteIdAndAnneeValeur(entiteId, anneeValeur)
                .orElseThrow(() -> new EntityNotFoundException("Aucune année trouvée pour l'entité et la valeur donnée."));

        return new ListIdDto(
                getId(annee.getGeneralOnglet()),
                getId(annee.getEnergieOnglet()),
                getId(annee.getAchatOnglet()),
                getId(annee.getAutreImmobilisationOnglet()),
                getId(annee.getAutreMobFrOnglet()),
                getId(annee.getBatimentImmobilisationMobilierOnglet()),
                getId(annee.getDechetOnglet()),
                getId(annee.getEmissionFugitiveOnglet()),
                getId(annee.getMobiliteDomicileTravailOnglet()),
                getId(annee.getMobInternationalOnglet()),
                getId(annee.getNumeriqueOnglet()),
                getId(annee.getParkingVoirieOnglet()),
                getId(annee.getVehiculeOnglet())
        );
    }

    private Long getId(Onglet onglet) {
        return onglet != null ? onglet.getId() : null;
    }

}
