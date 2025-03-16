package tcucl.back_tcucl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcucl.back_tcucl.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
