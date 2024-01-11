package elite.sas.core.api.dto;

import elite.sas.core.entities.Log;

public record LogDTO(String id, String attachmentWeekId, String workDone, String industrySupervisorComment,
                     String schoolSupervisorComment) {

    public static LogDTO from(Log l) {
        return new LogDTO(l.getId().toString(), l.getAttachmentWeek().getId().toString(), l.getWorkDone(), l.getIndustrySupervisorComment(), l.getSchoolSupervisorComment());
    }
}
