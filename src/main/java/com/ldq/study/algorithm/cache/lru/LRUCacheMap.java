package com.ldq.study.algorithm.cache.lru;


import java.util.HashMap;
import java.util.Map;

public class LRUCacheMap<K, V> {
    private int capacity;
    private Entry<K, V> first;
    private Entry<K, V> tail;
    private Map<K, Entry<K, V>> cache;


    class Entry<K, V> {
        public Entry pre;
        public Entry next;
        public K key;
        public V value;
    }

    public void put(K key, V value) {
        Entry entry = getEntry(key);
//        说明不存在当前key
        if (entry == null) {
//            需要添加当前key
            if (cache.size() >= capacity) {
                cache.remove(tail.key);
                removeLast();
            }
            entry = new Entry();
            entry.key = key;
            entry.value = value;
        }

        moveToFirst(entry);
        cache.put(key, entry);
    }

    public LRUCacheMap(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }


    public void remove(K key) {
        Entry entry = getEntry(key);
//        如果entry不为空，表示存在当前key节点
        if (entry != null) {
//            断开与前一个节点连接，让前一个节点指向entry的下一个节点
            if (entry.pre != null) {
                entry.pre.next = entry.next;
            }
//            断开与后一个节点的连接，让后一个节点指向entry的前一个节点
            if (entry.next != null) {
                entry.next.pre = entry.pre;
            }
//            如果first指向当前节点，则将first指向entry的下一个节点
            if (entry == first) {
                first = entry.next;
            }
//            如果tail指向当前节点，则将tail指向entry的前一个节点
            if (entry == tail) {
                tail = entry.pre;
            }
        }
        cache.remove(key);
    }

    public Entry<K, V> get(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            return null;
        }
        moveToFirst(entry);
        return null;
    }

    private void moveToFirst(Entry<K, V> entry) {
//        如果添加元素和头结点相同，直接返回
        if (entry == first) {
            return;
        }
//        如果entry的前一个节点不为空，则将前一个节点的后继节点指向entry的后继节点
//        相当于断开了entry节点的前一个节点的连接
        if (entry.pre != null) {
            entry.pre.next = entry.next;
        }

        if (entry.next != null) {
            entry.next.pre = entry.pre;
        }

        if (entry == tail) {
            tail = tail.pre;
        }
//        如果是第一次初始化添加，则头尾节点都指向entry
        if (first == null || tail == null) {
            first = tail = entry;
            return;
        }

//        将entry节点的后继节点指向头结点
        entry.next = first;
//        将头结点的前一个接待指向entry
        first.pre = entry;
//        将头结点指向entry节点
        first = entry;
//        将entry节点的前一个节点置为null
        entry.pre = null;
    }

    private void removeLast() {
        if (tail != null) {
            tail = tail.pre;
            if (tail == null) {
                first = null;
            } else {
                tail.next = null;
            }
        }
    }

    private Entry<K, V> getEntry(K key) {
        return cache.get(key);
    }

}
