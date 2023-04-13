package elite.sas.core.repository;

import elite.sas.core.entities.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ListingRepository extends JpaRepository<Listing, UUID> {
}
