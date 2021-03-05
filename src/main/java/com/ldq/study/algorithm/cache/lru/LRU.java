package com.ldq.study.algorithm.cache.lru;

import java.util.Iterator;
import java.util.LinkedList;

public class LRU<K, V> {

    LinkedList<Node<K, V>> cache;
    int capacity;

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    public void put(K key, V value) {
        //先遍历查找是否有key 的元素, 有则删除，重新添加到链尾
        Iterator<Node<K,V>> iterator = cache.iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key) {
                iterator.remove();
                break;
            }
        }

        if (capacity == cache.size()) {
            //缓存已满，删除一个 最近最少访问的元素（链表头）
            cache.removeLast();
        }
        cache.addFirst(new Node(key, value));
    }

    public Node<K, V> get(K key) {
        if (cache == null) {
            return null;
        }
        for (Node<K, V> node : cache) {
            if (key == node.key) {
                put(node.key, node.value);
                return node;
            }
        }
        return null;
    }

    class Node<K, V> {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
