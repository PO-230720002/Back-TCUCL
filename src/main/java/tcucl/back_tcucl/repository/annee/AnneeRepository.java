package tcucl.back_tcucl.repository.annee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcucl.back_tcucl.entity.annee.Annee;

@Repository
public interface AnneeRepository<T extends Annee> extends JpaRepository<T, Long> {
}
