package tcucl.back_tcucl.repository.parametre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.MachineEmissionFugitive;

@Repository
public interface MachineEmissionFugitiveRepository extends JpaRepository<MachineEmissionFugitive, Long> {
}
