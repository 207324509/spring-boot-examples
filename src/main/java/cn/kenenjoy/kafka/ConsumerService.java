package cn.kenenjoy.kafka;

/**
 * Created by hefa on 2018/1/8.
 */
public interface ConsumerService {
    /**
     * 接收消息
     *
     * @param content
     */
    void processMessage(String content);
}
