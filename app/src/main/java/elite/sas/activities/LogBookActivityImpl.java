package elite.sas.activities;

import elite.sas.activities.definition.LogBookActivity;
import elite.sas.entities.AttachmentWeek;
import elite.sas.entities.Log;
import elite.sas.repository.AttachmentWeekRepository;
import elite.sas.repository.LogRepository;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.Optional;


@RequiredArgsConstructor
public class LogBookActivityImpl implements LogBookActivity {

    private final AttachmentWeekRepository attachmentWeekRepository;
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
    public AttachmentWeek processAttachmentWeek(AttachmentWeek attachmentWeek) {

        if (Objects.isNull(attachmentWeek.getWeekSummary())) {
            attachmentWeek.setWeekSummary("No record");
            attachmentWeek = attachmentWeekRepository.save(attachmentWeek);
        }

        if (Objects.isNull(attachmentWeek.getStudentComment())) {
            attachmentWeek.setStudentComment("No comment");
            attachmentWeek = attachmentWeekRepository.save(attachmentWeek);
        }

        return attachmentWeek;
    }
}
