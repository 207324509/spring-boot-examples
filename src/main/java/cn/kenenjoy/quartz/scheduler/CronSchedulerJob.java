package cn.kenenjoy.quartz.scheduler;

import cn.kenenjoy.quartz.job.ScheduledJob1;
import cn.kenenjoy.quartz.job.ScheduledJob2;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;


/**
 * 固定等待时间
 * Created by hefa on 2017/12/11.
 */
@Component
public class CronSchedulerJob {

    private static final Logger log = LoggerFactory.getLogger(CronSchedulerJob.class);

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    public void scheduleJobs() {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduleJob1(scheduler);
        scheduleJob2(scheduler);
    }

    private void scheduleJob1(Scheduler scheduler) {
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob1.class).withIdentity("job1", "group1").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/6 * * * * ?");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(scheduleBuilder).build();
        try {
            scheduler.scheduleJob(jobDetail, cronTrigger);
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }

    private void scheduleJob2(Scheduler scheduler) {
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob2.class).withIdentity("job2", "group2").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/12 * * * * ?");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2").withSchedule(scheduleBuilder).build();
        try {
            scheduler.scheduleJob(jobDetail, cronTrigger);
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }


}
