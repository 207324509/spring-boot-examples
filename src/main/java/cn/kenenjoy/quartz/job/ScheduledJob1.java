package cn.kenenjoy.quartz.job;

import cn.kenenjoy.jms.impl.JMSProducer;
import cn.kenenjoy.kafka.ProducerService;
import cn.kenenjoy.util.DateUtils;
import org.apache.activemq.command.ActiveMQQueue;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jms.Destination;

/**
 * Created by hefa on 2017/12/11.
 */
public class ScheduledJob1 implements Job {
    private static final Logger log = LoggerFactory.getLogger(ScheduledJob1.class);

    @Autowired
    private JMSProducer jmsProducer;

    @Autowired
    private ProducerService producerService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        log.info("schedule job1 is running ...");
        Destination destination = new ActiveMQQueue("someQueue");
        jmsProducer.sendMessage(destination, DateUtils.getNowDate());

        producerService.sendMessage("someTopic", "www.kenenjoy.cn", DateUtils.getNowDate());
    }
}
