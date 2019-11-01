package com.dc.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author duanchao
 * @CreateDate: 2019/9/23 0023 11:44
 */
public class RedisClient {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    public boolean set(String key,Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public <V> V get1(final String key) {
        return (V) redisTemplate.opsForValue().get(key);
    }
}
