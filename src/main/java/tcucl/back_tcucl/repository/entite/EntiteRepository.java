package tcucl.back_tcucl.repository.entite;

import org.springframework.data.jpa.repository.JpaRepository;
import tcucl.back_tcucl.entity.entite.Entite;

public interface EntiteRepository<T extends Entite> extends JpaRepository<T, Long> {
}
