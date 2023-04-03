package elite.sas.cron;

import elite.sas.util.TemporalUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;



@Slf4j
public class DailyLogJob implements Job {


    @Override
    public void execute(JobExecutionContext context) {
        // start processing workflow
        String result = TemporalUtil.processDailyLogBookWorkflow().handle();
        log.info(result);

    }
}
