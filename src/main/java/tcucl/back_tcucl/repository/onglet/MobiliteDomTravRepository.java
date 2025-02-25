package tcucl.back_tcucl.repository.onglet;

import org.springframework.data.jpa.repository.JpaRepository;
import tcucl.back_tcucl.entity.onglet.MobiliteDomTravOnglet;
@Repository
public interface MobiliteDomTravRepository extends JpaRepository<MobiliteDomTravOnglet, Long> {
}
