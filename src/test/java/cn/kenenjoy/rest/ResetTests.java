package cn.kenenjoy.rest;

import cn.kenenjoy.domain.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by hefa on 2018/1/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResetTests {

    @Autowired
    private ResetService resetService;

    @Test
    public void testGreeting() {
        Result result = resetService.someRestCall("151xxxxxxxx");
        System.out.println(result.toString());
    }
}
