package tcucl.back_tcucl.entity.onglet.numerique.enums;

public enum EnumNumerique_Equipement {
    ECRAN(0),
    ENCEINTES(1),
    IMPRIMANTE_JET_ENCRE(2),
    IMPRIMANTE_LASER(3),
    ORDINATEUR_FIXE(4),
    ORDINATEUR_FIXE_HAUTE_PERFORMANCE(5),
    ORDINATEUR_PORTABLE(6),
    PHOTOCOPIEURS(7),
    SMARTPHONE(8),
    TABLETTE(9),
    TELEVISION_MOYENNE_30_49_POUCES(10),
    TELEVISION_GRANDE_55_POUCES(11),
    ECRAN_PUBLICITAIRE_2M2(12),
    VIDEOPROJECTEURS(13),
    BAIE_DE_DISQUES(14),
    MODEM(15),
    RACKS(16),
    SERVEUR(17),
    SWITCH_ROUTEUR_FIREWALL(18),
    AUTRE_NUMERIQUE_EN_EUROS(19);

    private final int code;

    EnumNumerique_Equipement(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static EnumNumerique_Equipement fromCode(int code) {
        for (EnumNumerique_Equipement e : values()) {
            if (e.code == code) {
                return e;
            }
        }
        throw new IllegalArgumentException("Code invalide : " + code);
    }
}
