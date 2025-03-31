package tcucl.back_tcucl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcucl.back_tcucl.entity.Entite;
import tcucl.back_tcucl.entity.Utilisateur;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Boolean existsUtilisateurByEmail(String email);

    Optional<Utilisateur> findByEmail(String email);

    Optional<Utilisateur> findById(Long id);

    List<Utilisateur> findAllByEntiteId(Long entiteId);
}
