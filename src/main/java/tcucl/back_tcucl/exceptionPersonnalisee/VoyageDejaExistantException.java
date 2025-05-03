package tcucl.back_tcucl.exceptionPersonnalisee;

import tcucl.back_tcucl.entity.onglet.mobInternationale.enums.EnumMobInternationale_NomPays;

import static tcucl.back_tcucl.Constante.ERREUR_VOYAGE_EXISTE_DEJA;

public class VoyageDejaExistantException extends RuntimeException {
    public VoyageDejaExistantException(EnumMobInternationale_NomPays pays) {
        super(ERREUR_VOYAGE_EXISTE_DEJA + pays);
    }
}
