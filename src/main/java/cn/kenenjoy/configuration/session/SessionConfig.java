package cn.kenenjoy.configuration.session;


import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by hefa on 2017/7/29.
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60) // session 60秒失效，默认1800秒
public class SessionConfig {
}
