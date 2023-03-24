package elite.sas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AttachmentWeekRepository extends JpaRepository<elite.sas.entities.AttachmentWeek, UUID> {
}
