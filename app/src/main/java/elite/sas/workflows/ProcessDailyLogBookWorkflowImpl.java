package elite.sas.workflows;

import elite.sas.activities.definition.LogBookActivity;
import elite.sas.entities.Attachment;
import elite.sas.entities.AttachmentWeek;
import elite.sas.entities.Log;
import elite.sas.util.TemporalUtil;
import elite.sas.util.TimeUtil;
import elite.sas.workflows.definition.ProcessDailyLogBookWorkflow;
import elite.sas.workflows.definition.WorkflowStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Slf4j
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
    public String handle() {
        AtomicInteger counter = new AtomicInteger();
        status = WorkflowStatus.EXECUTING;
        // fetch log for the previous day, if not exists, create with previous day timestamp and finally process
        var activeAttachments = logBookActivity.getActiveAttachments();
        if (activeAttachments.isEmpty()) {
            log.info("-------> No active attachments as at {}", TimeUtil.toString(Calendar.getInstance().getTimeInMillis()));
            status = WorkflowStatus.SUCCESSFUL;
            return "-------> No active attachments as at " + TimeUtil.toString(Calendar.getInstance().getTimeInMillis());
        }

        for (Attachment attachment : activeAttachments) {
            var optionalAttachmentWeek = attachment.getAttachmentWeeks().stream().filter(AttachmentWeek::isActive).findFirst();
            if (optionalAttachmentWeek.isEmpty()) {
                continue;
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

        status = WorkflowStatus.SUCCESSFUL;

        return "Processed " + counter.get() + " log entries  for " + activeAttachments.size() + " active attachments";
    }
}
