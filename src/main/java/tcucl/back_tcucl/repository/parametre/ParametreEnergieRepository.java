package tcucl.back_tcucl.repository.parametre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcucl.back_tcucl.entity.parametre.energie.ParametreEnergie;

@Repository
public interface ParametreEnergieRepository extends JpaRepository<ParametreEnergie, Long> {
}
