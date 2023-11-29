package com.wsj.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * ClassName:RedisConfig
 * Package:IntelliJ IDEA
 * Description:
 *
 * @Author 吴苏杰
 * @Create 2023/11/29 10:03
 * @Version 1.0
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory connectionFactory){
        // 创建RedisTemplate对象
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        // 设置连接工厂
        template.setConnectionFactory(connectionFactory);

        // 创建JSON序列化工具
        GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();

        // 设置Key的序列化
        template.setKeySerializer(RedisSerializer.string());
        template.setHashKeySerializer(RedisSerializer.string());

        // 设置Value的序列化
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashKeySerializer(jackson2JsonRedisSerializer);
        //返回
        return template;

    }

}
