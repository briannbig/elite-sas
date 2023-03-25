package elite.sas.cron;

import elite.sas.entities.Attachment;
import elite.sas.entities.AttachmentWeek;
import elite.sas.entities.Log;
import elite.sas.logger.FileLogger;
import elite.sas.repository.AttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DailyLogJob implements Job {
    @Autowired
    private LogCronProcessor logCronProcessor;
    @Autowired
    private AttachmentRepository attachmentRepository;


    @Override
    public void execute(JobExecutionContext context) {
        // 1. fetch all active attachments
        var activeAttachments = attachmentRepository.findAll().stream()
                .filter(Attachment::isActive).toList();
        // 2. fetch log for the previous day, if not exists, create with previous day timestamp and finally process
        activeAttachments.forEach(
                attachment -> {
                    var optionalAttachmentWeek = attachment.getAttachmentWeeks().stream().filter(AttachmentWeek::isActive).findFirst();
                    if (optionalAttachmentWeek.isEmpty()) {
                        return;
                    }
                    var optionalLog = optionalAttachmentWeek.get().previousDayLog();
                    if (optionalLog.isEmpty()){
                        Log log = Log.builder()
                                .createdAt(LocalDateTime.now().minusDays(1))
                                .build();
                        optionalAttachmentWeek.get().getLogs().add(log);
                        optionalLog = Optional.of(log);
                    }
                    var log = logCronProcessor.process(optionalLog.get());
                    FileLogger.getInstance().log(log);
                }
        );
    }
}
