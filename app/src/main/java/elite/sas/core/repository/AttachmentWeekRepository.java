package elite.sas.core.repository;

import elite.sas.core.entities.AttachmentWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AttachmentWeekRepository extends JpaRepository<AttachmentWeek, UUID> {
}
