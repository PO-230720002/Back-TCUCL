package tcucl.back_tcucl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcucl.back_tcucl.entity.Annee;

@Repository
public interface AnneeRepository<T extends Annee> extends JpaRepository<T, Long> {
}
