package com.wsj.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.naming.Name;

@SpringBootTest
class RedisDemoApplicationTests {

    //注入redisTemplate
    @Autowired
    private RedisTemplate redisTemplate;

    //测试使用
    @Test
    public void testRedisTemplate(){
        //添加值
        redisTemplate.opsForValue().set("name","皮卡丘屁屁");
        //获取值
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name："+name);
    }
}
