package elite.sas.core.api.dto;

import java.util.List;

public record AttachmentWeekDTO(String id, String attachmentId, int weekNumber, List<LogDTO> logs,
                                String weekSummary, String studentComment, String industrySupervisorComment,
                                String schoolSupervisorComment, boolean isActive) {
}
