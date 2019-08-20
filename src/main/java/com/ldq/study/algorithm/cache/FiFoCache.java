package com.ldq.study.algorithm.cache;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 思想是先进先出（FIFO，队列），这是最简单、最公平的一种思想.
 * 即如果一个数据是最先进入的，那么可以认为在将来它被访问的可能性很小。
 * 空间满的时候，最先进入的数据会被最早置换（淘汰）掉
 */
public class FiFoCache<K> extends LinkedList<K> {

    private int cacheSize;

    public FiFoCache(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void put(K key) {
        if (size() >= cacheSize) {
            removeFirst();
        }

        add(key);
    }

    public K get() {
        return removeFirst();
    }

    public static void main(String[] args) {
        FiFoCache<String> cache = new FiFoCache<>(10);
        for (int i = 0; i < 10; i++) {
            cache.add("k" + i);
        }
        System.out.println("init cache:" + cache);

        cache.put("n1");
        System.out.println("cache = " + cache);

        System.out.println("cache.get() = " + cache.get());

        System.out.println("cache = " + cache);
    }
}
