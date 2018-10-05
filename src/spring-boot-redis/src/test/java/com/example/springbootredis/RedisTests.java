package com.example.springbootredis;

import com.example.springbootredis.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ming.zhao
 * @Date: 2018-10-05 20:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception {
        User user = new User("aa@gmail.com", "aa", "aa123456");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("com.example", user);
        operations.set("com.example.timeout", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);

        boolean exists = redisTemplate.hasKey("com.example.timeout");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
    }
}
