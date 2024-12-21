package com.petproject.tech_blog.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // Save data to Redis
    public void save(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // Save data with expiration time
    public void saveWithExpiration(String key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    // Retrieve data from Redis
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // Delete data from Redis
    public void delete(String key) {
        redisTemplate.delete(key);
    }
}
