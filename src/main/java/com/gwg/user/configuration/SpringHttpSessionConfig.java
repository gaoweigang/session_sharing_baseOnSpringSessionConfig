package com.gwg.user.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.session.SessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;

/**
 * 
 *HttpSession配置文件，可以使用EnableRedisHttpSession替代
 */
@Configuration
@EnableSpringHttpSession
//@EnableRedisHttpSession //可以使用替代
public class SpringHttpSessionConfig {

    /**
     * @Bean(name={"a", "b}) 如果配置了name，使用name的，否则使用方法的名称
     * RedisConnectionFactory如果提供了相应的jar包并且配置application.yml，则Springboot会自动生成RedisConnectionFactory
     */
    @Bean
    public SessionRepository<?> sessionRepository(RedisConnectionFactory redisConnectionFactory) {
        RedisOperationsSessionRepository redisSessionRepository = 
                new RedisOperationsSessionRepository(redisConnectionFactory);
        redisSessionRepository.setDefaultMaxInactiveInterval(60);//设置Redis中HttpSession过期时间，默认是1800秒，测试使用60秒
        redisSessionRepository.setRedisKeyNamespace("gaoweigang");
        return redisSessionRepository;
    }
}