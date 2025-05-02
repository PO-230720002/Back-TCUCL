package tcucl.back_tcucl.entity.parametre.energie.enums;

public enum EnumEnergie_UniteFioul {
    TONNE(0),
    MWH_PCS(1),
    M3(2);

    private final int code;

    EnumEnergie_UniteFioul(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static EnumEnergie_UniteFioul fromCode(int code) {
        for (EnumEnergie_UniteFioul e : values()) {
            if (e.code == code) {
                return e;
            }
        }
        throw new IllegalArgumentException("Code invalide : " + code);
    }
}

