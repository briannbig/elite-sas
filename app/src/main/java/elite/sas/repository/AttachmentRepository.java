package elite.sas.repository;


import elite.sas.entities.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {

    List<Attachment> findByTenantId(UUID tenantId);

    Optional<Attachment> findByStudentAdmissionNumber(UUID studentAdmissionNumber);

    Optional<Attachment> findByStudentCourseId(UUID courseId);


    /**
     * fetches attachments where student comes from school with given tenant id
     * @param tenantId school id
     */
    List<Attachment> findByStudentAppUserTenantId(UUID tenantId);
}
