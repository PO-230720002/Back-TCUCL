package tcucl.back_tcucl.entity.parametre.vehicule.enums;

public enum EnumVehicule_Type {
    VOITURE_THERMIQUE(0),
    VOITURE_ELECTRIQUE(1),
    VOITURE_HYBRIDE(2);

    private final int code;

    EnumVehicule_Type(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static EnumVehicule_Type fromCode(int code) {
        for (EnumVehicule_Type e : values()) {
            if (e.code == code) {
                return e;
            }
        }
        throw new IllegalArgumentException("Code invalide : " + code);
    }
}
