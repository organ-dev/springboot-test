package com.example.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: ld
 * @Date: 2018/9/19 14:28
 * @Description:
 */
public class IncrementHash {

    public Long incrementHash(String key, String hashKey, Long delta) throws Exception {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        try {
            if (null == delta) {
                delta = 1L;
            }
            return template.opsForHash().increment(key, hashKey, delta);
        } catch (Exception e) {//redis宕机时采用uuid的方式生成唯一id
            int first = new Random(10).nextInt(8) + 1;
            int randNo = UUID.randomUUID().toString().hashCode();
            if (randNo < 0) {
                randNo = -randNo;
            }
            return Long.valueOf(first + String.format("%16d", randNo));
        }
    }

    public Long generateId(String key) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        RedisAtomicLong counter = new RedisAtomicLong(key, template.getConnectionFactory());
        counter.expire(100, TimeUnit.DAYS);
        return counter.incrementAndGet();
    }

    public static void main(String[] args) {
        IncrementHash incrementHash = new IncrementHash();
        String uuid = incrementHash.generateId("1").toString();
    }
}
