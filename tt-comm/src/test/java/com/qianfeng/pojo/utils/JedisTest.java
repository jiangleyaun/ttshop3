/*package com.qianfeng.pojo.utils;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JedisTest {
    @Test
    public void testJedis1(){
        //Jedis jedis = new Jedis("47.100.31.218",6379);
        Jedis jedis = new Jedis("47.100.31.218", 6379);
        //jedis.auth("123");
        Map<String,String> map = new HashMap<String, String>();
        map.put("name","jiang");
        map.put("password","123");
        jedis.hmset("mykey1",map);
    }
    @Test
    public void testJedis2(){
        JedisPool jedisPool = new JedisPool("47.100.31.218", 6379);
        Jedis jedis = jedisPool.getResource();
    }

    @Test
    public void testJedis3(){
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        //将6个节点加入到集合中
        nodes.add(new HostAndPort("47.100.31.218",9001));
        nodes.add(new HostAndPort("47.100.31.218",9002));
        nodes.add(new HostAndPort("47.100.31.218",9003));
        nodes.add(new HostAndPort("47.100.31.218",9004));
        nodes.add(new HostAndPort("47.100.31.218",9005));
        nodes.add(new HostAndPort("47.100.31.218",9006));
        //使用构造方法创建集群对象
        JedisCluster jedisCluster = new JedisCluster(nodes);
        System.out.println(jedisCluster.get("name"));
    }
}*/
