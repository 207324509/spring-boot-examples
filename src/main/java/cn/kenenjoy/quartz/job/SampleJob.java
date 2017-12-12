package cn.kenenjoy.quartz.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by hefa on 2017/12/11.
 */
public class SampleJob extends QuartzJobBean {
    private static final Logger log = LoggerFactory.getLogger(SampleJob.class);

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void executeInternal(org.quartz.JobExecutionContext jobExecutionContext) {
        log.info("hello " + this.name + "!");
    }
}
