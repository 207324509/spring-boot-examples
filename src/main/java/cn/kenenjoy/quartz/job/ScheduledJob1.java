package cn.kenenjoy.quartz.job;

import cn.kenenjoy.jms.impl.JMSProducer;
import cn.kenenjoy.kafka.ProducerService;
import cn.kenenjoy.util.DateUtils;
import org.apache.activemq.command.ActiveMQQueue;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * Created by hefa on 2017/12/11.
 */
@Component
public class ScheduledJob1 extends QuartzJobBean {
    private static final Logger log = LoggerFactory.getLogger(ScheduledJob1.class);

    @Autowired
    private JMSProducer jmsProducer;

    @Autowired
    private ProducerService producerService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("schedule job1 is running ...");
        Destination destination = new ActiveMQQueue("someQueue");
        jmsProducer.sendMessage(destination, DateUtils.getNowDate());

        producerService.sendMessage("someTopic", "www.kenenjoy.cn", DateUtils.getNowDate());
    }
}
