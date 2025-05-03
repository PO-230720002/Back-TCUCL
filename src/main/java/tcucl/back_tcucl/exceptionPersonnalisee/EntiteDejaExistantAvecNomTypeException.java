package tcucl.back_tcucl.exceptionPersonnalisee;

import static tcucl.back_tcucl.Constante.ERREUR_ENTITE_EXISTE_DEJA;

public class EntiteDejaExistantAvecNomType extends RuntimeException {
    public EntiteDejaExistantAvecNomType(String entiteNom, String entiteType) {
        super(ERREUR_ENTITE_EXISTE_DEJA+ "  " + entiteNom + "  " + entiteType);
    }
}
