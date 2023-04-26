package elite.sas.core.cron;

import elite.sas.core.util.TemporalUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Checks if student has written week summary and comments then closes as no record if neither is written
 *
 */
@Slf4j
public class WeeklyLogJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String result = TemporalUtil.processWeeklyLogsWorkflow().handle();
        log.info(result);
    }
}
