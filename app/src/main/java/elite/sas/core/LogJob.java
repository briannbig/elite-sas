package elite.sas.core;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class LogJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // TODO: 3/24/23 : create log as not submitted if student has not entered that days entry
    }
}
