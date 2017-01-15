package config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author 天脉(yangtao.lyt)
 * @version 2017年01月13 13:19
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 10)
public class RedisSessionConfig  {


}
