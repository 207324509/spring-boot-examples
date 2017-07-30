package cn.kenenjoy.mail;

/**
 * Created by hefa on 2017/7/29.
 */
public interface MailService {
    /**
     * 发送简单的文件
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送html格式邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath);
}
