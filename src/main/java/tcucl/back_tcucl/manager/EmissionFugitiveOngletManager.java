package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.dto.MachineEmissionFugitiveDto;
import tcucl.back_tcucl.entity.onglet.EmissionFugitiveOnglet;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.MachineEmissionFugitive;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.enums.EnumEmissionFugitive_TypeFluide;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.enums.EnumEmissionFugitive_TypeMachine;

public interface EmissionFugitiveOngletManager {

    EmissionFugitiveOnglet getEmissionFugitiveOngletById(Long id);

    MachineEmissionFugitive getMachineById(Long ongletId, Long machineId);

    void ajouterMachine(Long id, MachineEmissionFugitiveDto machineEmissionFugitiveDto);

    void supprimerMachineFromOnglet(Long ongletId, Long machineId);

    void setNomMachine(Long ongletId, Long machineId, String nomMachine);

    void setDescriptionMachine(Long ongletId, Long machineId, String descriptionMachine);

    void setValeurEnumTypeFluide(Long ongletId, Long machineId, EnumEmissionFugitive_TypeFluide typeFluide);

    void setQuantiteFluideKg(Long ongletId, Long machineId, Float quantiteFluideKg);

    void setTauxDeFuiteConnu(Long ongletId, Long machineId, Boolean tauxDeFuiteConnu);

    void setTauxDeFuite(Long ongletId, Long machineId, Float tauxDeFuite);

    void setValeurEnumTypeMachine(Long ongletId, Long machineId, EnumEmissionFugitive_TypeMachine typeMachine);

}
