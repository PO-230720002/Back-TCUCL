package tcucl.back_tcucl.service;

import tcucl.back_tcucl.dto.onglet.mobInternational.MobInternationalOngletDto;
import tcucl.back_tcucl.dto.onglet.mobInternational.VoyageVersUneDestinationMobInternationaleDto;
import tcucl.back_tcucl.entity.onglet.mobInternationale.MobInternationalOnglet;

public interface MobInternationalOngletService {

    MobInternationalOnglet getMobInternationalOngletById(Long ongletId);

    void updateMobInternationalOngletPartiel(Long ongletId, MobInternationalOngletDto mobInternationalOngletDto);

    void ajouterVoyage(Long ongletId, VoyageVersUneDestinationMobInternationaleDto voyageVersUneDestinationMobInternationaleDto);

    void supprimerVoyage(Long ongletId, Long voyageId);

    void updateVoyagePartiel(Long ongletId, Long voyageId, VoyageVersUneDestinationMobInternationaleDto dto);

}
