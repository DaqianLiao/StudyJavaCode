package com.ldq.study.algorithm.leetcode;

import com.sun.tools.javac.comp.Lower;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

        int[] num = {1,2,3,4,4,5,6,7,8,9};
        int target = 10;
        twoSum(num,target);
    }

    private static void twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int loss = target - nums[i];
            if(map.containsKey(loss)){
                System.out.print("first num index = " + i + ", second num index= " + map.get(loss));
                System.out.println("; first num = " + nums[i] + ", second num index= " + nums[map.get(loss)]);
            }
            map.put(nums[i], i);
        }
    }
}
