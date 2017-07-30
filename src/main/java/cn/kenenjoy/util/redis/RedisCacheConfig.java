package cn.kenenjoy.util.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

/**
 * Created by hefa on 2017/7/29.
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Bean
    public RedisTemplate redisTemplate(){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        // 开启事务支持
        redisTemplate.setEnableTransactionSupport(true);
        // 使用String格式序列化 或 JDK序列化
        JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
        redisTemplate.setKeySerializer(jdkSerializationRedisSerializer);
        redisTemplate.setValueSerializer(jdkSerializationRedisSerializer);
        return redisTemplate;
    }

    @Bean
    public RedisCacheManager cacheManager(){
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate());
        redisCacheManager.setDefaultExpiration(30);
        return redisCacheManager;
    }

}
