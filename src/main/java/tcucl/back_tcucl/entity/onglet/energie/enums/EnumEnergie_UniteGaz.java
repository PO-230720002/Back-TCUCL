package tcucl.back_tcucl.entity.onglet.energie.enums;

public enum EnumEnergie_UniteGaz {
    MWH_PCS(0),
    M3(1);

    private final int code;

    EnumEnergie_UniteGaz(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static EnumEnergie_UniteGaz fromCode(int code) {
        for (EnumEnergie_UniteGaz e : values()) {
            if (e.code == code) {
                return e;
            }
        }
        throw new IllegalArgumentException("Code invalide : " + code);
    }
}
