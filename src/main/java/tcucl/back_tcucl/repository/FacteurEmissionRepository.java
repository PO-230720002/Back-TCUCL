package tcucl.back_tcucl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tcucl.back_tcucl.entity.FacteurEmission;

public interface FacteurEmissionRepository extends JpaRepository<FacteurEmission, Long> {
}
