package elite.sas.cron;

import elite.sas.entities.AttachmentWeek;
import elite.sas.repository.AttachmentWeekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Objects;
import java.util.UUID;

/**
 * Checks if student has written week summary and comments then closes as no record if neither is written
 *
 */
@RequiredArgsConstructor
public class WeeklyCronProcessor extends BaseCronProcessor<AttachmentWeek> {
    @Autowired
    private final AttachmentWeekRepository attachmentWeekRepository;


    @Override
    protected JpaRepository<AttachmentWeek, UUID> repository() {
        return attachmentWeekRepository;
    }

    @Override
    public AttachmentWeek process(AttachmentWeek attachmentWeek) {

        if (Objects.isNull(attachmentWeek.getWeekSummary())) {
            attachmentWeek.setWeekSummary("No record");
            attachmentWeek = repository().save(attachmentWeek);
        }
        if (Objects.isNull(attachmentWeek.getStudentComment())) {
            attachmentWeek.setStudentComment("No comment");
            attachmentWeek = repository().save(attachmentWeek);
        }

        return attachmentWeek;
    }
}
