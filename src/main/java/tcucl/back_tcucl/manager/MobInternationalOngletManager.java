package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.dto.onglet.mobInternational.MobInternationalOngletDto;
import tcucl.back_tcucl.dto.onglet.mobInternational.VoyageVersUneDestinationMobInternationaleDto;
import tcucl.back_tcucl.entity.onglet.mobInternationale.MobInternationalOnglet;
import tcucl.back_tcucl.entity.onglet.mobInternationale.VoyageVersUneDestinationMobInternationale;

public interface MobInternationalOngletManager {

    MobInternationalOnglet getMobInternationalOngletById(Long ongletId);

    VoyageVersUneDestinationMobInternationale getVoyageById(Long ongletId, Long voyageId);

    void updateMobInternationalOngletPartiel(Long ongletId, MobInternationalOngletDto mobInternationalOngletDto);

    void ajouterVoyage(Long ongletId, VoyageVersUneDestinationMobInternationaleDto voyageDto);

    void supprimerVoyage(Long ongletId, Long voyageId);

    void updateVoyagePartiel(Long ongletId, Long voyageId, VoyageVersUneDestinationMobInternationaleDto voyageVersUneDestinationMobInternationaleDto);
}
