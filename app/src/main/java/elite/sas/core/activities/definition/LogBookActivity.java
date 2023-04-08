package elite.sas.core.activities.definition;

import elite.sas.core.entities.Attachment;
import elite.sas.core.entities.AttachmentWeek;
import elite.sas.core.entities.Log;
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
