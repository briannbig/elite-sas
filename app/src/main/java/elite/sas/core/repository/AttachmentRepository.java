package elite.sas.core.repository;


import elite.sas.core.entities.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {

    List<Attachment> findByTenantId(UUID tenantId);

    Optional<Attachment> findByStudentAdmissionNumber(String studentAdmissionNumber);

    Optional<Attachment> findByStudentCourseId(UUID courseId);


    Optional<Attachment> findByStudentId(UUID studentId);

    /**
     * fetches attachments where student comes from school with given tenant id
     *
     * @param tenantId school id
     */
    List<Attachment> findByStudentAppUserTenantId(UUID tenantId);

    List<Attachment> findByAttachmentPeriod(String attachmentPeriod);

    List<Attachment> findByIndustrySupervisorId(UUID supervisorId);

    List<Attachment> findBySchoolSupervisorId(UUID supervisorId);
}
