package cn.kenenjoy.quartz;

import cn.kenenjoy.quartz.scheduler.CronSchedulerJob;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by hefa on 2017/12/11.
 */
@Configuration
@EnableScheduling
@Component
public class SchedulerListener {
    @Autowired
    public CronSchedulerJob scheduleJobs;

    @Scheduled(cron = "0 30 11 25 11 ?")
    public void schedule() throws SchedulerException {
        scheduleJobs.scheduleJobs();
    }
}
