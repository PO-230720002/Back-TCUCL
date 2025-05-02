package tcucl.back_tcucl.service;

import tcucl.back_tcucl.dto.onglet.mobInternational.MobInternationalOngletDto;
import tcucl.back_tcucl.dto.onglet.mobInternational.VoyageVersUneDestinationMobInternationaleDto;
import tcucl.back_tcucl.entity.onglet.MobInternationalOnglet;

public interface MobInternationalOngletService {

    MobInternationalOnglet getMobInternationalOngletById(Long id);

    void updateMobInternationalOngletPartiel(Long id, MobInternationalOngletDto mobInternationalOngletDto);

    void ajouterVoyage(Long id, VoyageVersUneDestinationMobInternationaleDto voyageVersUneDestinationMobInternationaleDto);

    void supprimerVoyage(Long ongletId, Long voyageId);

    void updateVoyagePartiel(Long ongletId, Long voyageId, VoyageVersUneDestinationMobInternationaleDto dto);

}
