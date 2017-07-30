package cn.kenenjoy.mail;

import cn.kenenjoy.mail.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by hefa on 2017/7/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void testSimpleMail(){
        //mailService.sendSimpleMail("1003703936@qq.com","spring boot","Hello this is simple mail");
    }
}
