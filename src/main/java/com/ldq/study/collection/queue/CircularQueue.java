package com.ldq.study.collection.queue;

import java.util.Arrays;

/**
 *
 */
public class CircularQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head 表示队头下标，tail 表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为 capacity 的数组
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队方法
     * 由于队列底层使用数组，因此数组大小固定
     * 空队列的条件：tail = head
     * 满队列的条件：(tail + 1)/n = head
     *     这个条件下实际存储的数据大小为 n-1个元素
     *     优化方案是在初始化的时候将容量默认扩充为n = capacity +1
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        // 队列满了
        if ((tail + 1) % n == head) return false;
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    // 出队
    public String dequeue() {
        // 如果 head == tail 表示队列为空
        if (head == tail) return null;
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

    @Override
    public String toString() {
        return "CircularQueue{" +
                "items=" + Arrays.toString(items) +
                '}';
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(10);
        //初始化就将数组填满
        for (int i = 0; i < 10; i++) {
            System.out.println(" item" +i +", put success:" + queue.enqueue("item" + i));
        }

        System.out.println(queue.toString());

        System.out.println(queue.dequeue());
        System.out.println(queue.enqueue("new" + 1));
        System.out.println(queue.toString());
        System.out.println(queue.dequeue());

    }
}

