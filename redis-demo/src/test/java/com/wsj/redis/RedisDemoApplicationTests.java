package com.wsj.redis;

import com.wsj.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisDemoApplicationTests {

    //注入redisTemplate
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    //测试使用
    @Test
    public void testRedisTemplate(){
        //添加值
        redisTemplate.opsForValue().set("name","皮卡丘屁屁");
        //获取值
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name："+name);
    }

    @Test
    public void testRedisTemplate1(){
        User user = new User("吴苏杰",22);
        redisTemplate.opsForValue().set("user:1",user);
        User o = (User)redisTemplate.opsForValue().get("user:1");
        System.out.println("user："+o);

    }

}
