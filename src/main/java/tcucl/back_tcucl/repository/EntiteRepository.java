package tcucl.back_tcucl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcucl.back_tcucl.entity.Entite;

@Repository
public interface EntiteRepository extends JpaRepository<Entite, Long> {

    public Entite findEntiteById(Long id);
}
