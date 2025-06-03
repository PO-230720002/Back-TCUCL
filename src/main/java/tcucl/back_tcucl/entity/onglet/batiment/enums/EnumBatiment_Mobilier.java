package tcucl.back_tcucl.entity.onglet.batiment.enums;

public enum EnumBatiment_Mobilier {

    ARMOIRE(0),
    CANAPE(1),
    CHAISES_BOIS(2),
    CHAISES_BOIS_TEXTILE(3),
    CHAISES_PLASTIQUES(4),
    CHAISES_MOYENNE(5),
    LIT(6),
    TABLE(7),
    ASPIRATEUR_CLASSIQUE(8),
    ASPIRATEUR_TRAINEAU_PRO(9),
    CLIMATISEUR_MOBILE(10),
    CONGELATEUR_ARMOR(11),
    CONGELATEUR_COFFRE(12),
    LAVELINGE_7KG(13),
    SECHE_LINGE_6KG(14),
    LAVE_VAISSELLE(15),
    MACHINE_A_CAFE_EXPRESSO(16),
    MACHINE_A_CAFE_FILTRE(17),
    MACHINE_A_CAFE_DOSETTES(18),
    MACHINE_A_CAFE_MOYENNE(19),
    BOUILLOIRE(20),
    MICRO_ONDES(21),
    PLAQUES_DE_CUISSON(22),
    RADIATEUR_ELECTRIQUE(23),
    REFRIGERATEUR(24),
    AUTRE_MOBILIER_EN_EUROS(25),
    AUTRE_MOBILIER_EN_TONNES(26);

    private final int code;

    EnumBatiment_Mobilier(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static EnumBatiment_Mobilier fromCode(int code) {
        for (EnumBatiment_Mobilier e : values()) {
            if (e.code == code) {
                return e;
            }
        }
        throw new IllegalArgumentException("Code invalide : " + code);
    }
}
