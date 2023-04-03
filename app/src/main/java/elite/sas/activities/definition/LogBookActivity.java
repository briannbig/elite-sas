package elite.sas.activities.definition;

import elite.sas.entities.Attachment;
import elite.sas.entities.AttachmentWeek;
import elite.sas.entities.Log;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.util.List;
import java.util.Optional;

@ActivityInterface
public interface LogBookActivity {

    @ActivityMethod
    Optional<Log> processLogEntry(Log logEntry);

    @ActivityMethod
    AttachmentWeek processAttachmentWeek(AttachmentWeek attachmentWeek);

    @ActivityMethod
    List<Attachment> getActiveAttachments();
}
