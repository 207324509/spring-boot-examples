package cn.kenenjoy.jms;

/**
 * Created by hefa on 2018/1/8.
 */
public interface Consumer {
    void processMessage(String content);
}
