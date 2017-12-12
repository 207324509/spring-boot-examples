package cn.kenenjoy.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hefa on 2017/12/11.
 */
public class ScheduledJob2 implements Job {
    private static final Logger log = LoggerFactory.getLogger(ScheduledJob2.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("schedule job2 is running ...");
    }
}
