package cn.kenenjoy.util.redis;

import cn.kenenjoy.domain.User;
import cn.kenenjoy.util.UUIDTool;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by hefa on 2017/7/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    public RedisTemplate redisTemplate;

    /**
     * 针对String
     */
    @Autowired
    public StringRedisTemplate stringRedisTemplate;


    @Test
    public void testString() {
        stringRedisTemplate.opsForValue().set("hello", "world");
        Assert.assertEquals("world", stringRedisTemplate.opsForValue().get("hello"));
    }

    @Test
    public void testObject() {
        User user = new User(UUIDTool.getUUID(),"杰","王","18616716219","wangjie@jie.com");

        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        operations.set("user1",user);
        // 带过期时间参数
        operations.set("user2",user,1, TimeUnit.SECONDS);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean exists = redisTemplate.hasKey("user2");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }

         Assert.assertEquals("杰", operations.get("user1").getFirstname());
    }
}
