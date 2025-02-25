package tcucl.back_tcucl.repository.parametre;

import org.springframework.data.jpa.repository.JpaRepository;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.MachineEmissionFugitive;

public interface MachineEmissionFugitiveRepository extends JpaRepository<MachineEmissionFugitive, Long> {
}
