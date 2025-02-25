package tcucl.back_tcucl.repository.onglet;

import org.springframework.data.jpa.repository.JpaRepository;
import tcucl.back_tcucl.entity.onglet.EnergieOnglet;
@Repository
public interface EnergieRepository extends JpaRepository<EnergieOnglet, Long> {
}
