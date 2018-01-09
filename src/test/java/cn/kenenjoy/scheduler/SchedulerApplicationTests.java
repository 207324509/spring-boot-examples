package cn.kenenjoy.scheduler;

import cn.kenenjoy.jms.impl.JMSProducer;
import cn.kenenjoy.kafka.ProducerService;
import cn.kenenjoy.util.DateUtils;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

/**
 * Created by hefa on 2017/12/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SchedulerApplicationTests {
    @Autowired
    private JMSProducer jmsProducer;

    @Autowired
    private ProducerService producerService;

    @Test
    public void contextLoads() {
        System.out.println("hello world!");
        Destination destination = new ActiveMQQueue("someQueue");
        jmsProducer.sendMessage(destination, DateUtils.getNowDate());
        producerService.sendMessage("someTopic", "www.kenenjoy.cn", DateUtils.getNowDate());
    }
}
