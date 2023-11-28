package com.wsj.jedis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * ClassName:JedisConnectionFactory
 * Package:IntelliJ IDEA
 * Description:
 *
 * @Author 吴苏杰
 * @Create 2023/11/28 23:34
 * @Version 1.0
 */

//Jedis连接池配置
public class JedisConnectionFactory {
    private final static JedisPool jedisPool;

    static {
        // 配置连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(8);//最大连接数
        poolConfig.setMaxIdle(8);//最大空闲连接
        poolConfig.setMinIdle(0);//最小空闲连接
        poolConfig.setMaxWaitMillis(1000);//最长等待时间 单位：毫秒
        // 创建连接池对象，参数：连接池配置、服务端ip、服务端端口、超时时间、密码
        jedisPool = new JedisPool(poolConfig, "192.168.31.128", 6379, 1000, "123456");
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
