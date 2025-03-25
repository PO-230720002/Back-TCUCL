package tcucl.back_tcucl.entity.parametre.energie.enums;

public enum EnumEnergie_UniteBois {
    TONNE(0),
    MWH_PCS(1);

    private final int code;

    EnumEnergie_UniteBois(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static EnumEnergie_UniteBois fromCode(int code) {
        for (EnumEnergie_UniteBois e : values()) {
            if (e.code == code) {
                return e;
            }
        }
        throw new IllegalArgumentException("Code invalide : " + code);
    }
}
