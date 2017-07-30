package cn.kenenjoy.mail;

import cn.kenenjoy.mail.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hefa on 2017/7/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void sendSimpleMail(){
        mailService.sendSimpleMail("1003703936@qq.com","spring boot simple mail","Hello this is simple mail");
    }

    @Test
    public void sendHtmlMail(){
        String content=
                "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("1003703936@qq.com","spring boot simple mail",content);
    }

    @Test
    public void sendAttachmentsMail() throws MalformedURLException {
        String filePath="/Users/hefa/Downloads/favicon.ico";
        mailService.sendAttachmentsMail("1003703936@qq.com","spring boot simple mail","有附件，请查收！",filePath);
    }
}
