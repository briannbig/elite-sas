package elite.sas.core.api.dto;

import elite.sas.core.entities.AttachmentPeriod;

import java.time.LocalDateTime;
import java.util.List;

public record AttachmentDTO(String id, StudentDTO student, TenantDTO company, AttachmentPeriod attachmentPeriod,
                            LocalDateTime startDate, LocalDateTime endDate, UserDTO industrySupervisor,
                            UserDTO schoolSupervisor, List<AttachmentWeekDTO> attachmentWeeks) {
}
