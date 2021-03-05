package com.ldq.study.algorithm.cache.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * LRU（The Least Recently Used，最近最久未使用算法）。
 * LRU算法的思想是：
 * 如果一个数据在最近一段时间没有被访问到，那么可以认为在将来它被访问的可能性也很小。
 * 因此，当空间满时，最久没有访问的数据最先被置换（淘汰）。
 *
 * 简单用LinkedHashMap来实现的LRU算法的缓存
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;

    public LRUCache(int cacheSize) {
        super(16, (float) 0.75, true);
        this.cacheSize = cacheSize;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(10);

        for (int i = 0; i < 10; i++) {
            cache.put("k" + i, i);
        }

        System.out.println("init cache = " + cache.toString());
        cache.get("k3");
        System.out.println("get k3 = " + cache.toString());
        cache.get("k4");

        System.out.println("get k4 = " + cache.toString());
        cache.get("k4");

        System.out.println("get k4 = " + cache.toString());
        cache.put("k" + 10, 10);
        System.out.println("put K10 = " + cache.toString());
    }
}
