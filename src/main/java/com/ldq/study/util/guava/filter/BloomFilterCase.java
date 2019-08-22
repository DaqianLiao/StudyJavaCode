package com.ldq.study.util.guava.filter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;

import java.text.DecimalFormat;

public class BloomFilterCase {
    @Test
    public void bloomBase() {
        int capacity = 1000000;
        int key = 6666;
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), capacity);
        for (int i = 0; i < capacity; i++) {
            bloomFilter.put(i);
        }
        /**返回计算机最精确的时间，单位纳妙 */
        long start = System.nanoTime();
        if (bloomFilter.mightContain(key)) {
            System.out.println("成功过滤到" + key);
        }
        long end = System.nanoTime();
        System.out.println("布隆过滤器消耗时间:" + (end - start));
    }

    @Test
    public void error() {
        int capacity = 1000000;
        /**
         * 表示误判率
         * 如果不传，默认为 0.03
         */
        double fpp = 0.01;
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), capacity, fpp);
        for (int i = 0; i < capacity; i++) {
            bloomFilter.put(i);
        }
        int sum = 0;
        for (int i = capacity + 20000; i < capacity + 30000; i++) {
            if (bloomFilter.mightContain(i)) {
                sum++;
            }
        }
        //0.03
        DecimalFormat df = new DecimalFormat("0.00");//设置保留位数
        System.out.println("错判率为:" + df.format((float) sum / 10000));
    }
}
