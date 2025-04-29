package tcucl.back_tcucl.repository.onglet;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tcucl.back_tcucl.entity.onglet.EnergieOnglet;

@Repository
public interface EnergieOngletRepository extends JpaRepository<EnergieOnglet, Long> {

}