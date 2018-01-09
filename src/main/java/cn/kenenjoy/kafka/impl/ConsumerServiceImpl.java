package cn.kenenjoy.kafka.impl;

import cn.kenenjoy.kafka.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by hefa on 2018/1/9.
 */
@Component
public class ConsumerServiceImpl implements ConsumerService {

    private static final Logger log = LoggerFactory.getLogger(ConsumerServiceImpl.class);

    @KafkaListener(topics = "someTopic")
    public void processMessage(String content) {
        log.info("接收到的消息:" + content);
    }
}
