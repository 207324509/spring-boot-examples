package cn.kenenjoy.quartz.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 固定时间间隔
 * Created by hefa on 2017/12/11.
 */
@Configuration
public class SampleScheduler {
    private static final Logger log = LoggerFactory.getLogger(SampleScheduler.class);

//    @Autowired
//    private Scheduler scheduler;
//
//    private JobDetail sampleJobDetail() {
//        return JobBuilder.newJob(SampleJob.class).withIdentity("sampleJob").usingJobData("name", "World").storeDurably().build();
//    }
//
//    private Trigger sampleJobTrigger() {
//        /**
//         * 执行时间间隔2秒钟
//         */
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();
//        return TriggerBuilder.newTrigger().forJob(sampleJobDetail()).withIdentity("sampleTrigger", "group3").withSchedule(scheduleBuilder).build();
//    }
//
//    /**
//     * 加载任务
//     */
//    public void scheduleJobs() {
//        try {
//            scheduler.scheduleJob(sampleJobDetail(), sampleJobTrigger());
//        } catch (SchedulerException e) {
//            log.error(e.getMessage(), e);
//        }
//    }
}
