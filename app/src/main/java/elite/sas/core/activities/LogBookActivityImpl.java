package elite.sas.core.activities;

import elite.sas.core.activities.definition.LogBookActivity;
import elite.sas.core.entities.Attachment;
import elite.sas.core.entities.AttachmentWeek;
import elite.sas.core.entities.Log;
import elite.sas.core.repository.AttachmentRepository;
import elite.sas.core.repository.AttachmentWeekRepository;
import elite.sas.core.repository.LogRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RequiredArgsConstructor
public class LogBookActivityImpl implements LogBookActivity {

    private final AttachmentWeekRepository attachmentWeekRepository;
    private final AttachmentRepository attachmentRepository;
    private final LogRepository logRepository;


    @Override
    public Optional<Log> processLogEntry(Log logEntry) {
        if (Objects.isNull(logEntry.getWorkDone())) {
            logEntry.setWorkDone("No record");
            logEntry = logRepository.save(logEntry);
        }
        return Optional.of(logEntry);
    }

    @Override
    public Optional<AttachmentWeek> processAttachmentWeek(AttachmentWeek attachmentWeek) {

        boolean needsToBeUpdated = (Objects.isNull(attachmentWeek.getWeekSummary()) ||
                Objects.isNull(attachmentWeek.getStudentComment()));

        if (Objects.isNull(attachmentWeek.getWeekSummary())) {
            attachmentWeek.setWeekSummary("No record");
        }

        if (Objects.isNull(attachmentWeek.getStudentComment())) {
            attachmentWeek.setStudentComment("No comment");
        }

        if (needsToBeUpdated) {
            attachmentWeek = attachmentWeekRepository.save(attachmentWeek);
        }

        return Optional.of(attachmentWeek);
    }

    @Override
    public Optional<AttachmentWeek> createNextAttachmentWeek(AttachmentWeek attachmentWeek) {

        if (!attachmentWeek.getAttachment().isActive()) {
            return Optional.empty();
        }

        var nextAttachmentWeek = AttachmentWeek.builder()
                .weekNumber(attachmentWeek.getWeekNumber()+1)
                .attachment(attachmentWeek.getAttachment()).build();
        AttachmentWeek week = attachmentWeekRepository.save(nextAttachmentWeek);

        return Optional.of(week);
    }

    @Override
    public List<Attachment> getActiveAttachments() {
        return attachmentRepository.findAll().stream()
                .filter(Attachment::isActive).toList();
    }
}
