package cn.kenenjoy.kafka.impl;

import cn.kenenjoy.kafka.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by hefa on 2018/1/9.
 */
@Component
public class ProducerServiceImpl implements ProducerService {

    private static final Logger log = LoggerFactory.getLogger(ProducerServiceImpl.class);

    private final KafkaTemplate kafkaTemplate;

    @Autowired
    public ProducerServiceImpl(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String topic, String key, String data) {
        log.info("topic:" + topic + " key:" + key + " data:" + data);
        kafkaTemplate.send(topic, key, data);
    }
}