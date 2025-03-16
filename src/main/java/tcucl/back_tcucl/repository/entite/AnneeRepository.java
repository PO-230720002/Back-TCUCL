package tcucl.back_tcucl.repository.entite;

import org.springframework.data.jpa.repository.JpaRepository;
import tcucl.back_tcucl.entity.entite.Annee;

public interface AnneeRepository<T extends Annee> extends JpaRepository<T, Long> {
}
