package tcucl.back_tcucl.entity.parametre.dechet.enums;

public enum EnumDechet_Traitement {
    RECYCLAGE(0),
    INCINERATION(1),
    STOCKAGE(2);

    private final int code;

    EnumDechet_Traitement(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static EnumDechet_Traitement fromCode(int code) {
        for (EnumDechet_Traitement e : values()) {
            if (e.code == code) {
                return e;
            }
        }
        throw new IllegalArgumentException("Code invalide : " + code);
    }
}
