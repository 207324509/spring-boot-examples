package cn.kenenjoy.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * Created by hefa on 2018/1/8.
 */
@Component
public class JMSProducer {
    private static final Logger log = LoggerFactory.getLogger(JMSProducer.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 发送消息
     *
     * @param destination 发送到的队列
     * @param message     发送的内容
     */
    public void sendMessage(Destination destination, final String message) {
        log.info("向队列：" + destination + " 发送消息:" + message);
        jmsTemplate.convertAndSend(destination, message);
    }
}
