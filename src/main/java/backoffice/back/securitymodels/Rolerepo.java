package backoffice.back.securitymodels;

import backoffice.back.securitymodels.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Rolerepo extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
