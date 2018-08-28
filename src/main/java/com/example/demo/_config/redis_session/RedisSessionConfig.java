package com.example.demo._config.redis_session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 600) // seconds
public class RedisSessionConfig {
    //    @Bean
    //    public ConfigureRedisAction enableRedisKeyspaceNotificationsInitializer() {
    //        return ConfigureRedisAction.NO_OP;
    //    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        redisTemplate.setEnableDefaultSerializer(true);
        redisTemplate.setDefaultSerializer(stringSerializer);

        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        redisTemplate.setStringSerializer(stringSerializer);

        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

}
