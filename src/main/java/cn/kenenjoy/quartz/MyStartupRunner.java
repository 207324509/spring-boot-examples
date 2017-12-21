package cn.kenenjoy.quartz;

import cn.kenenjoy.quartz.scheduler.CronSchedulerJob;
import cn.kenenjoy.quartz.scheduler.SampleScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 服务启动执行
 * Created by hefa on 2017/12/11.
 */
public class MyStartupRunner implements CommandLineRunner {

//    private static final Logger log = LoggerFactory.getLogger(MyStartupRunner.class);
//
//    @Autowired
//    private CronSchedulerJob scheduleJobs;
//    @Autowired
//    private SampleScheduler sampleSchedulers;

    @Override
    public void run(String... args) throws Exception {
//        scheduleJobs.scheduleJobs();
//        sampleSchedulers.scheduleJobs();
//        log.info(">>>>>>>>>>>>>>>定时任务开始执行<<<<<<<<<<<<<");
    }
}
