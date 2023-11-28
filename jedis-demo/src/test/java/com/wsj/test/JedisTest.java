package com.wsj.test;

import com.wsj.jedis.utils.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;

/**
 * ClassName:JedisTest
 * Package:IntelliJ IDEA
 * Description:
 *
 * @Author 吴苏杰
 * @Create 2023/11/28 23:12
 * @Version 1.0
 */
public class JedisTest {
    //建立连接
    private Jedis jedis;

    @BeforeEach
    public void setUp(){
        //1、建立连接
        //jedis = new Jedis("192.168.31.128", 6379);
        //使用Jedis连接池
        jedis = JedisConnectionFactory.getJedis();

        //2、输入密码
        jedis.auth("123456");
        //3、选择库
        jedis.select(2);
    }

    //测试
    @Test
    public void testString(){
        //存入数据
        String result = jedis.set("name", "吴苏杰");
        System.out.println("result:"+result);
        //读取数据
        String name = jedis.get("name");
        System.out.println("name:"+name);
    }

    @Test
    public void testHash(){
        //存入数据
        jedis.hset("user:1","name","Jack");
        jedis.hset("user:1","age","22");
        //读取数据
        String name = jedis.hget("user:1", "name");
        System.out.println("hset,name:"+name);
        Map<String, String> usermap = jedis.hgetAll("user:1");
        System.out.println(usermap);

    }

    //关闭连接
    @AfterEach
    public void tearDown(){
        if (jedis != null){
            jedis.close();
        }
    }

}
