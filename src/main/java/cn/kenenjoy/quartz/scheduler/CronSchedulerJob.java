package cn.kenenjoy.quartz.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 固定等待时间
 * Created by hefa on 2017/12/11.
 */
@Component
public class CronSchedulerJob {

    private static final Logger log = LoggerFactory.getLogger(CronSchedulerJob.class);

//    @Autowired
//    private Scheduler scheduler;
//
//    /**
//     * 加载任务
//     */
//    public void scheduleJobs() {
//        this.scheduleJob1();
//        this.scheduleJob2();
//    }
//
//    /**
//     * 构建任务1
//     */
//    private void scheduleJob1() {
//        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob1.class).withIdentity("job1", "group1").build();
//        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/6 * * * * ?");
//        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(scheduleBuilder).build();
//        try {
//            scheduler.scheduleJob(jobDetail, cronTrigger);
//        } catch (SchedulerException e) {
//            log.error(e.getMessage(), e);
//        }
//    }
//
//    /**
//     * 构建任务2
//     */
//    private void scheduleJob2() {
//        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob2.class).withIdentity("job2", "group2").build();
//        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/12 * * * * ?");
//        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2").withSchedule(scheduleBuilder).build();
//        try {
//            scheduler.scheduleJob(jobDetail, cronTrigger);
//        } catch (SchedulerException e) {
//            log.error(e.getMessage(), e);
//        }
//    }


}
