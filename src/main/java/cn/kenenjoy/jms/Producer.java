package cn.kenenjoy.jms;


import javax.jms.Destination;

/**
 * Created by hefa on 2018/1/8.
 */
public interface Producer {

    /**
     * 发送消息
     *
     * @param destination 发送到的队列
     * @param message     发送的内容
     */
    void sendMessage(Destination destination, final String message);
}
