package elite.sas.cron;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


public class LogsCronRunner {
    private static LogsCronRunner INSTANCE = null;
    public static LogsCronRunner getInstance() {
        if (INSTANCE == null){
            INSTANCE = new LogsCronRunner();
        }
        return INSTANCE;
    }

    private LogsCronRunner() {}
    public void run() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDetail dailyLogsJob = JobBuilder.newJob(DailyLogJob.class)
                .withIdentity("dailyLogJob", "group1")
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("dailyLogsTrigger", "group1")
                .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(0, 0))
                .build();

        scheduler.scheduleJob(dailyLogsJob, trigger);
        scheduler.start();

    }
}
