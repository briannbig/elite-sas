package elite.sas.workflows;

import elite.sas.core.activities.definition.LogBookActivity;
import elite.sas.core.entities.Attachment;
import elite.sas.core.entities.AttachmentWeek;
import elite.sas.core.util.TemporalUtil;
import elite.sas.core.util.TimeUtil;
import elite.sas.core.workflows.definition.ProcessWeeklyLogsWorkflow;
import elite.sas.core.workflows.definition.WorkflowStatus;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class ProcessWeeklyLogsWorkflowImpl implements ProcessWeeklyLogsWorkflow {

    private final LogBookActivity logBookActivity = TemporalUtil.logBookActivityStub();


    private WorkflowStatus status = WorkflowStatus.STARTED;

    @Override
    public WorkflowStatus getStatus() {
        return status;
    }

    @Override
    public String handle() {

        AtomicInteger counter = new AtomicInteger();
        status = WorkflowStatus.EXECUTING;

        var activeAttachments = logBookActivity.getActiveAttachments();

        if (activeAttachments.isEmpty()) {
            log.info("-------> No active attachments as at {}", TimeUtil.toString(Calendar.getInstance().getTimeInMillis()));
            status = WorkflowStatus.SUCCESSFUL;
            return "-------> No active attachments as at " + TimeUtil.toString(Calendar.getInstance().getTimeInMillis());
        }

        for (Attachment attachment : activeAttachments) {
            var optionalAttachmentWeek = attachment.getAttachmentWeeks().stream().filter(AttachmentWeek::isActive).findFirst();

            if (optionalAttachmentWeek.isEmpty()) {
                break;
            }

            Optional<AttachmentWeek> processedAttachmentWeek = logBookActivity.processAttachmentWeek(optionalAttachmentWeek.get());
            if (processedAttachmentWeek.isEmpty()) {
                break;
            }

            Optional<AttachmentWeek> optionalNextAttachmentWeek = logBookActivity.createNextAttachmentWeek(processedAttachmentWeek.get());

            if (optionalNextAttachmentWeek.isPresent()) {
                counter.getAndIncrement();
            }

        }

        status = WorkflowStatus.SUCCESSFUL;

        return "Processed " + counter.get() + " log entries  for " + activeAttachments.size() + " active attachments";
    }
}
