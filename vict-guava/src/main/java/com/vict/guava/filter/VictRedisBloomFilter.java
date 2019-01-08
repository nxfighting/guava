package com.vict.guava.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

public class VictRedisBloomFilter<E> extends VictBloomFilter {

    @Autowired
    private RedisTemplate redisTemplate;

    public VictRedisBloomFilter(double c, int n, int k) {
        super(c, n, k);
    }

    public void addToRedis(E code) {
        int hash = VictBloomFilter.createHash(code.toString());
    }
}
