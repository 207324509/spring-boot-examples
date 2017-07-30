package cn.kenenjoy.mail;

/**
 * Created by hefa on 2017/7/29.
 */
public interface MailService {
    void sendSimpleMail(String to, String subject, String content);
}
