package com.vict.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BitMapTest {

    private static final long STORAGE_NUMBER = 10000000;
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void contextLoads() {
    }
    @Test
    public void testBloom(){
        for (int i = 0; i <10 ; i++) {
            System.out.println(UUID.randomUUID().toString().hashCode());
            redisTemplate.convertAndSend("a.b.c",UUID.randomUUID().toString());
        }

    }

}

