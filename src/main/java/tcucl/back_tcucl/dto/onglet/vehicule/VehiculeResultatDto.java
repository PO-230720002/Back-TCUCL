package tcucl.back_tcucl.dto.onglet.vehicule;

import java.util.Map;

public class VehiculeResultatDto {
    private Map<Long,Float> emissionGESVehicule;

    private Float totalEmissionGES;

    public VehiculeResultatDto() {
    }

    public Map<Long, Float> getEmissionGESVehicule() {
        return emissionGESVehicule;
    }

    public void setEmissionGESVehicule(Map<Long, Float> emissionGESVehicule) {
        this.emissionGESVehicule = emissionGESVehicule;
    }

    public Float getTotalEmissionGES() {
        return totalEmissionGES;
    }

    public void setTotalEmissionGES(Float totalEmissionGES) {
        this.totalEmissionGES = totalEmissionGES;
    }
}
