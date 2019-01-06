package com.vict.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuavaApplicationTests {

    private static final long STORAGE_NUMBER = 10000000;

    @Test
    public void contextLoads() {
    }
    @Test
    public void testBloom(){
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), STORAGE_NUMBER);
        List<String> filterd = new ArrayList<>();
        String uuid="";
        for (long i = 0; i < STORAGE_NUMBER/10; i++) {
            uuid = UUID.randomUUID().toString();
            bloomFilter.put(uuid);
            if (i < 10) {
                filterd.add(uuid);
            }
        }
        System.out.println(String.format("过滤器中误差率：[%s]",bloomFilter.expectedFpp()));
        System.out.println(String.format("过滤器中HashCode：[%s]",bloomFilter.hashCode()));
        System.out.println(String.format("过滤器中误差率：[%s]",bloomFilter.test(uuid)));
        System.out.println(String.format("过滤器中数据量：[%s]",bloomFilter.approximateElementCount()));


        System.out.println(String.format("可能存在[AA]:%s",bloomFilter.mightContain("AA")));
        filterd.forEach(text->{
            System.out.println(String.format("可能存在[%s]:%s",text,bloomFilter.mightContain(text)));

        });


    }

}

