package elite.sas.core.repository;

import elite.sas.core.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, UUID> {
    List<Application> findByApplicantTenantId(UUID tenantId);

    List<Application> findByApplicantId(UUID userId);

    List<Application> findByListingId(UUID listingId);
}
