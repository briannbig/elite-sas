package elite.sas.repository;

import elite.sas.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TenantRepository extends JpaRepository<Tenant, UUID> {

    Optional<Tenant> findByName(String name);

    Optional<Tenant> findByEmail(String email);

    Optional<Tenant> findByTelephone(String telephone);
}
