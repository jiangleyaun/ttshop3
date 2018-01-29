package com.qianfeng.jediscluster;

import com.qianfeng.pojo.jedis.JedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisCluster;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-jedis-test.xml"})
public class JedisClusterTest {
    @Autowired
    private JedisCluster jedisCluster;
    @Autowired
    private JedisClient jedisClient;

    @Test
    public void testGet(){
        try {
            jedisClient.hset("key2", "name", "111");

            System.out.println(jedisCluster.hget("key2", "name"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}*/
