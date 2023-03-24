package elite.sas;

import elite.sas.core.LogJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class App {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // Define the job
        JobDetail job = JobBuilder.newJob(LogJob.class)
                .withIdentity("logJob", "group1")
                .build();

        // Define a cron trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myCronTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")) // fire every 1 minutes
                .build();

        // Schedule the job with the trigger
        scheduler.scheduleJob(job, trigger);

        // Start the scheduler
        scheduler.start();
    }
}
