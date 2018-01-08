package cn.kenenjoy.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by hefa on 2018/1/8.
 */
@Component
public class JMSConsumer {
    private static final Logger log = LoggerFactory.getLogger(JMSConsumer.class);

    @JmsListener(destination = "someQueue")
    public void processMessage(String content) {
        log.info("接收消息:" + content);
    }
}
