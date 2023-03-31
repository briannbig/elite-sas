package elite.sas.workflows;

import elite.sas.activities.definition.LogBookActivity;
import elite.sas.entities.Attachment;
import elite.sas.entities.AttachmentWeek;
import elite.sas.entities.Log;
import elite.sas.util.TemporalUtil;
import elite.sas.workflows.definition.ProcessDailyLogBookWorkflow;
import elite.sas.workflows.definition.WorkflowStatus;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class ProcessDailyLogBookWorkflowImpl implements ProcessDailyLogBookWorkflow {

    private final LogBookActivity logBookActivity = TemporalUtil.logBookActivityStub();


    private WorkflowStatus status = WorkflowStatus.STARTED;
    @Override
    public WorkflowStatus getStatus() {
        return status;
    }

    /**
     * fetch log for the previous day for each active attachment, if not exists, create with previous day timestamp and finally process
     */
    @Override
    public String handle(List<Attachment> activeAttachments) {
        AtomicInteger counter = new AtomicInteger();
        status = WorkflowStatus.EXECUTING;
        // fetch log for the previous day, if not exists, create with previous day timestamp and finally process
        activeAttachments.forEach(
                attachment -> {
                    var optionalAttachmentWeek = attachment.getAttachmentWeeks().stream().filter(AttachmentWeek::isActive).findFirst();
                    if (optionalAttachmentWeek.isEmpty()) {
                        return;
                    }
                    var optionalLog = optionalAttachmentWeek.get().previousDayLog();

                    Log logEntry = optionalLog.orElseGet(() -> Log.builder()
                            .createdAt(LocalDateTime.now().minusDays(1))
                            .build());

                    Optional<Log> optionalLogEntry = logBookActivity.processLogEntry(logEntry);

                    if (optionalLogEntry.isPresent()) {
                        counter.getAndIncrement();
                    }
                }
        );

        status = WorkflowStatus.SUCCESSFUL;

        return "Processed " + counter.get() + " log entries  for " + activeAttachments.size() + " active attachments";
    }
}
