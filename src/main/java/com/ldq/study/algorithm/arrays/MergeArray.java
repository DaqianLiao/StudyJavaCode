package com.ldq.study.algorithm.arrays;

public class MergeArray {
//    给出两个有序的整数数组A和B ，请将数组B合并到数组A中，变成一个有序的数组
//    注意：
//    可以假设A数组有足够的空间存放B数组的元素， A和B中初始的元素数目分别为m和n
    public void merge(int[] A, int m, int[] B, int n) {
        int right = A.length - 1;
        int i = m-1,j=n-1;

        while(i>=0&&j>=0){
            A[right --] = A[i]>B[j]?A[i--]:B[j--];
        }
        while(i>=0){
            A[right--] = A[i--];
        }
        while(j>=0){
            A[right--] = B[j--];
        }
    }
}
