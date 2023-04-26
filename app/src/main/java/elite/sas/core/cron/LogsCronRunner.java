package elite.sas.core.cron;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;


public class LogsCronRunner {
    private static LogsCronRunner INSTANCE = null;

    public static LogsCronRunner getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LogsCronRunner();
        }
        return INSTANCE;
    }

    private LogsCronRunner() {
    }

    public void run() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail dailyLogsJob = JobBuilder.newJob(DailyLogJob.class)
                .withIdentity("dailyLogJob", "group1")
                .build();
        JobDetail weeklyLogsJob = JobBuilder.newJob(WeeklyLogJob.class)
                .withIdentity("weeklyLogJob", "group2")
                .build();


        Trigger dailyLogsTrigger = TriggerBuilder.newTrigger()
                .withIdentity("dailyLogsTrigger", "group1")
                .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(0, 0))
                .build();

        Trigger weeklyLogsTrigger = TriggerBuilder.newTrigger()
                .withIdentity("weeklyLogsTrigger", "group2")
                .withSchedule(CronScheduleBuilder.weeklyOnDayAndHourAndMinute(DateBuilder.MONDAY, 0, 0))
                .build();

        scheduler.scheduleJob(dailyLogsJob, dailyLogsTrigger);
        scheduler.scheduleJob(weeklyLogsJob, weeklyLogsTrigger);

        scheduler.start();

    }
}
