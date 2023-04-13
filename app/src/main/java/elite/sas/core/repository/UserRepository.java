package elite.sas.core.repository;

import elite.sas.core.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<AppUser, UUID> {

    Optional<AppUser> findByUserName(String userName);

    List<AppUser> findByTenantId(UUID fromString);

}
