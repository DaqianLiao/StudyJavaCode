package com.ldq.study.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MintopK {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        if (k <= 0 || input == null || k > input.length || input.length == 0) {
            return new ArrayList<>();
        }
        int size = input.length;

        Fixed fix = new Fixed(k);
        for (int i = 0; i < size; i++) {
            fix.add(input[i]);
        }

        fix.sort();
        return fix.result;
    }

    private static class Fixed {
        public int maxLen;
        public ArrayList<Integer> result = new ArrayList();

        public Fixed(int mLen) {
            maxLen = mLen;
        }

        public void add(int num) {
            result.add(num);
            if (needDel()) {
                del();
            }
        }

        private boolean needDel() {
            return result.size() > maxLen;
        }

        private void del() {
            int max = result.stream().max(Integer::compareTo).get();
            result.remove(result.indexOf(max));
        }

        private void sort(){
            result.sort(Integer::compareTo);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 5, 2, 6, 7, 3, 8};
        ArrayList<Integer> integers = GetLeastNumbers_Solution(nums, 4);
        System.out.println("integers.toString() = " + integers.toString());

    }
}
