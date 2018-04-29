package cn.kenenjoy.ioc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by hefa on 2018/1/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestInjection {
    @Autowired
    private BeanInvoker beanInvoker;

    @Test
    public void getBeanInvoker() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        beanInvoker.say();
        String s1 = "s1";
        String s2 = new String("s2");
        String s3 = String.valueOf("s3");
        String s4 = (String) Class.forName(String.class.getName()).newInstance();


    }
}
