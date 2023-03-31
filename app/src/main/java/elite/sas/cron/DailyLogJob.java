package elite.sas.cron;

import elite.sas.entities.Attachment;
import elite.sas.repository.AttachmentRepository;
import elite.sas.util.TemporalUtil;
import elite.sas.util.TimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Calendar;


@RequiredArgsConstructor
@Slf4j
public class DailyLogJob implements Job {
    private final AttachmentRepository attachmentRepository;


    @Override
    public void execute(JobExecutionContext context) {
        // 1. fetch all active attachments
        var activeAttachments = attachmentRepository.findAll().stream()
                .filter(Attachment::isActive).toList();

        if (activeAttachments.isEmpty()) {
            log.info("-------> No active attachments as at {}", TimeUtil.toString(Calendar.getInstance().getTimeInMillis()));
        }

        // 2. start processing workflow
        String result = TemporalUtil.processDailyLogBookWorkflow().handle(activeAttachments);
        log.info(result);

    }
}
