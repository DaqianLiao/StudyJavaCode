package com.ldq.study.algorithm.find;

public class FindMain {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,0};

        int target=3;
        System.out.println(BinaryFind.binaryNormal(nums, target));
        System.out.println(BinaryFind.binaryFixBug(nums, target));
        System.out.println(BinaryFind.binaryWithCool(nums, target));
    }
}
