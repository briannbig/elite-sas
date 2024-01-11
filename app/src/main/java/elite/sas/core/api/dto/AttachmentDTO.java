package elite.sas.core.api.dto;

import elite.sas.core.entities.Attachment;
import elite.sas.core.entities.AttachmentPeriod;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record AttachmentDTO(String id, StudentDTO student, TenantDTO company, AttachmentPeriod attachmentPeriod,
                            LocalDateTime startDate, LocalDateTime endDate, UserDTO industrySupervisor,
                            UserDTO schoolSupervisor, List<AttachmentWeekDTO> attachmentWeeks) {
    public static AttachmentDTO fromModel(Attachment a) {
        return new AttachmentDTO(a.getId().toString(), StudentDTO.fromModel(a.getStudent()), TenantDTO.from(a.getTenant()),
                a.getAttachmentPeriod(), a.getStartDate(), a.getEndDate(), UserDTO.from(a.getIndustrySupervisor()), UserDTO.from(a.getSchoolSupervisor()),
                a.getAttachmentWeeks().stream().map(aw -> AttachmentWeekDTO.from(aw)).collect(Collectors.toList()));
    }
}
