package com.ldq.study.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序的时间复杂度，最好，最差，平均都是O(nlogn)，空间复杂度O(1)，是不稳定的排序
 * 堆（或二叉堆），类似于完全二叉树，除叶子节点外，每个节点均拥有左子树和右子树，同时左子树和右子树也是堆。
 * 小顶堆：父节点的值 <= 左右孩子节点的值
 * 大顶堆：父节点的值 >= 左右孩子节点的值
 * <p>
 * 对的排序是根据广度优先BFS排序的
 * 0
 * 1   2
 * 3 4 5 6
 * 对于数组中的第 i 个节点（从0开始），有如下规律：
 * 如果父节点存在，则它的父节点是 (i - 1) / 2； 比如3的父亲是(3-1)/2=1
 * 如果左孩子存在，则它的左孩子是 2 * i + 1； 比如1的左孩子是2*1+1=3
 * 如果右孩子存在，则右孩子是 2 * i + 2；比如1的右孩子是2*1+2=4
 */
public class HeapSort {
    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 由于是根据广度优先遍历
     * 因此数组的前N个数应该就是根节点
     * 所以i = array.length/2 - 1 开始调整堆
     *
     * @param arr
     */
    public static void create_heap(int[] arr) {
        System.out.print("source array:");
        print(arr);
        int end = arr.length - 1;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            fix_down(arr, i, end);
        }
        System.out.print("create heap: ");
        print(arr);
    }

    /**
     * 构建大、小顶堆
     * 从第length/2-1 位置开始调整
     * 每一步调整后，需要找到调整的子节点是否需要调整
     * @param arr
     * @param i
     * @param end
     */
    public static void fix_down(int[] arr, int i, int end) {
        int child = (i << 1) + 1; // 当前节点的左孩子
        int temp = arr[i];

        while (child <= end) {
            // 选出两个孩子较大的那个
            if (child < end && arr[child + 1] > arr[child]) {
                child++;
            }
            if (temp < arr[child]) {
                arr[i] = arr[child]; // 孩子节点与当前节点替换
                i = child;
                child = (i << 1) + 1;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }


    public static void head_sort(int[] arr) {
        // 取出堆顶元素，与最后一个元素交换，调整堆
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i]; // 最后一个元素
            arr[i] = arr[0];
            arr[0] = temp;
            fix_down(arr, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // Test case 1
        int[] arr = {19, 17, 20, 18, 16, 21,35};
        create_heap(arr); // 创建堆
        head_sort(arr);
        print(arr); // 16 17 18 19 20 21

        // Test case 2
        int[] arr1 = {16, 7, 3, 20, 17, 8};
        create_heap(arr1);
        head_sort(arr1);
        print(arr1); // 3 7 8 16 17 20

        // Test case 3
        int[] arr2 = {5, 4, 3, 2, 1};
        create_heap(arr2);
        head_sort(arr2);
        print(arr2); // 1 2 3 4 5

        // Test case 4
        int[] arr3 = {1, 1, 1, 1};
        create_heap(arr3);
        head_sort(arr3);
        print(arr3); // 1 1 1 1
    }

}
