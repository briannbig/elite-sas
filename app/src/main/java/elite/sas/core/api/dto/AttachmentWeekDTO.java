package elite.sas.core.api.dto;

import elite.sas.core.entities.AttachmentWeek;

import java.util.List;
import java.util.stream.Collectors;

public record AttachmentWeekDTO(String id, String attachmentId, int weekNumber, List<LogDTO> logs, String weekSummary,
                                String studentComment, String industrySupervisorComment, String schoolSupervisorComment,
                                boolean isActive) {

    public static AttachmentWeekDTO fromModel(AttachmentWeek attachmentWeek) {

        return new AttachmentWeekDTO(attachmentWeek.getId().toString(), attachmentWeek.getAttachment().getId().toString(), attachmentWeek.getWeekNumber(),
                attachmentWeek.getLogs().stream().map(log -> LogDTO.fromModel(log)).collect(Collectors.toList()), attachmentWeek.getWeekSummary(),
                attachmentWeek.getStudentComment(), attachmentWeek.getIndustrySupervisorComment(), attachmentWeek.getSchoolSupervisorComment(), attachmentWeek.isActive());
    }
}
