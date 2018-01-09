package cn.kenenjoy.kafka;

/**
 * Created by hefa on 2018/1/8.
 */
public interface ProducerService {

    /**
     * 发送消息
     * @param topic
     * @param key
     * @param data
     */
    void sendMessage(String topic, String key, String data);
}
