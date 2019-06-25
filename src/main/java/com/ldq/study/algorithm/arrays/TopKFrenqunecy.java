package com.ldq.study.algorithm.arrays;

import java.util.*;

public class TopKFrenqunecy {

    /**
     * 借助 哈希表 来建立数字和其出现次数的映射，遍历一遍数组统计元素的频率
     * 维护一个元素数目为 k 的最小堆
     * <p>
     * <p>
     * 空间复杂度：O(n)最坏的情况下，每个数据出现一次，map需要存储n个键值对
     * 空间复杂度：O(nlogk)
     * 遍历一遍数组统计元素的频率，这一系列操作的时间复杂度是 O(n)
     * 遍历用于存储元素频率的 map，如果元素的频率大于最小堆中顶部的元素，
     * 则将顶部的元素删除并将该元素加入堆中，这里维护堆的数目是 k，
     * 所以这一系列操作的时间复杂度是 O(nlogk)的
     *
     * @param nums
     * @param k
     * @return 当频数相同时，可能只会返回一个
     */
    public static List<Integer> topKFrequentWithHeap(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }

    /**
     * 首先依旧使用哈希表统计频率，统计完成后，
     * 创建一个数组，将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标即可
     * <p>
     * 空间复杂度：O(n)
     * 时间复杂度：O(n)
     * 遍历一遍数组统计元素的频率，时间复杂度是 O(n)
     * 桶的数量为 n + 1，所以桶排序的时间复杂度为 O(n)
     *
     * @param nums
     * @param k
     * @return 频数相同时，都会返回
     */
    public static List<Integer> topKFrequentWithBucket(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            // 获取出现的次数作为下标
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if (list[i] == null) continue;
            res.addAll(list[i]);
        }
        return res;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 1, 2, 2, 2, 3};
        int k = 1;
        System.out.println("topK  = " + k);
        System.out.println(topKFrequentWithHeap(nums, k));
        System.out.println(topKFrequentWithBucket(nums, k));

        k = 2;
        System.out.println("topK  = " + k);
        System.out.println(topKFrequentWithHeap(nums, k));
        System.out.println(topKFrequentWithBucket(nums, k));
    }
}
