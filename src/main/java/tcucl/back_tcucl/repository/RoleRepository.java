package tcucl.back_tcucl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tcucl.back_tcucl.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
