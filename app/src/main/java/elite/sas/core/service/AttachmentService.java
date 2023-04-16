package elite.sas.core.service;

import elite.sas.core.entities.*;
import elite.sas.core.repository.AttachmentRepository;
import elite.sas.core.repository.AttachmentWeekRepository;
import elite.sas.core.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AttachmentService {

    @Autowired
    private final AttachmentRepository attachmentRepository;

    @Autowired
    private final AttachmentWeekRepository attachmentWeekRepository;
    @Autowired
    private final LogRepository logRepository;


    public List<Attachment> getAllAttachments() {
        return attachmentRepository.findAll();
    }

    public List<Attachment> getAllActiveAttachments() {
        return getAllAttachments().stream().filter(Attachment::isActive).toList();
    }

    public Optional<Attachment> getAttachmentById(String id) {
        return attachmentRepository.findById(UUID.fromString(id));
    }

    public Optional<Attachment> getAttachmentsByCourseId(String courseId) {
        return attachmentRepository.findByStudentCourseId(UUID.fromString(courseId));
    }

    public Optional<Attachment> getAttachmentByStudentAdmissionNumber(String admissionNumber) {
        return attachmentRepository.findByStudentAdmissionNumber(UUID.fromString(admissionNumber));
    }

    public Optional<Attachment> getAttachmentByStudentId(String studentId) {
        return attachmentRepository.findByStudentId(UUID.fromString(studentId));
    }


    /**
     * @param tenantId company id
     * @return List of all attachments
     */

    public List<Attachment> getAllAttachmentsAtCompany(String tenantId) {
        return attachmentRepository.findByTenantId(UUID.fromString(tenantId));
    }

    /**
     * @param tenantId school id
     * @return List of all attachments
     */

    public List<Attachment> getAllAttachmentsFromSchool(String tenantId) {
        return attachmentRepository.findByStudentAppUserTenantId(UUID.fromString(tenantId));
    }

    public List<Attachment> getAllAttachmentsForIndustrySupervisor(String supervisorId) {
        return attachmentRepository.findByIndustrySupervisorId(UUID.fromString(supervisorId));
    }

    public List<Attachment> getAllAttachmentsForSchoolSupervisor(String tenantId) {
        return attachmentRepository.findBySchoolSupervisorId(UUID.fromString(tenantId));
    }

    public List<Attachment> getAllAttachmentsForPeriod(AttachmentPeriod attachmentPeriod) {
        return attachmentRepository.findByAttachmentPeriod(attachmentPeriod.name());
    }


    /**
     * active attachments at company xyz
     *
     * @param tenantId company id
     * @return List of active attachments
     */

    public List<Attachment> getActiveAttachmentsAtCompany(String tenantId) {
        return getAllAttachmentsAtCompany(tenantId).stream().filter(Attachment::isActive).toList();
    }

    /**
     * active attachments with students from school xyz
     *
     * @param tenantId school tenant id
     * @return List of active attachments
     */

    public List<Attachment> getActiveAttachmentsFromSchool(String tenantId) {
        return getAllAttachmentsFromSchool(tenantId).stream().filter(Attachment::isActive).toList();
    }

    /**
     * all students ever been attached at company xyz
     *
     * @param tenantId company Id
     * @return list of all students
     */
    public List<Student> getAllStudentsAtCompany(String tenantId) {
        return getAllAttachmentsAtCompany(tenantId).stream().map(Attachment::getStudent).toList();
    }

    /**
     * all students ever been attached from school xyz
     *
     * @param tenantId School id
     * @return list of all students
     */
    public List<Student> getAllStudentsFromSchool(String tenantId) {
        return getAllAttachmentsFromSchool(tenantId).stream().map(Attachment::getStudent).toList();
    }

    /**
     * all students with currently ongoing attachment at company xyz
     *
     * @param tenantId tenant id
     * @return List
     */
    public List<Student> getActiveStudentsAtCompany(String tenantId) {
        return getActiveAttachmentsAtCompany(tenantId).stream().map(Attachment::getStudent).toList();
    }

    /**
     * all students with currently ongoing attachment from school xyz
     *
     * @param tenantId school tenant id
     * @return List
     */
    public List<Student> getActiveStudentsFromSchool(String tenantId) {
        return getActiveAttachmentsFromSchool(tenantId).stream().map(Attachment::getStudent).toList();
    }


    public Optional<AttachmentWeek> getAttachmentWeekById(String weekId) {
        return attachmentWeekRepository.findById(UUID.fromString(weekId));
    }

    public Optional<Log> addLog(Log log) {
        return Optional.of(logRepository.save(log));
    }


}
