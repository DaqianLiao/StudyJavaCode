package com.ldq.study.algorithm.leetcode;

import java.util.Arrays;

/**
 * 洪水填充：当某个点向四周扩散，直接填充某个闭区域
 * 递归实现，容易导致递归深度较深而报错
 */
public class FloodFill {
    public static void printMap(int[][] map) {
        System.out.println("Now this map is filled as follow:");
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

    public static void floodFill4(int[][] map, int x, int y) {
        /**
         * 判断边界，如果达到边界，说明遇到墙了，不可以在扩容
         * 判断当前点是否是墙
         */
        if (x < 0 || y < 0 || x > map.length || y > map[x].length || map[x][y] == 1) {
            System.out.println("x = " + x + ", y = " + y + " 已达到边界!");
            return;
        } else {
            map[x][y] = 1;
            printMap(map);
            floodFill4(map, x - 1, y);
            floodFill4(map, x + 1, y);
            floodFill4(map, x, y - 1);
            floodFill4(map, x, y + 1);
        }

    }

    public static void main(String[] args) {
        int[][] map =
                {{0, 0, 1, 0},
                {1, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 0, 1, 0}};
        printMap(map);
        //正常扩容
//        System.out.println("正常填充：");
//        floodFill4(map, 0, 1);
//        System.out.println("=====================");
//        //边界点
//        System.out.println("边界点填充：");
//        floodFill4(map, 1, 0);
//        System.out.println("=====================");
        System.out.println("边界点填充：");
        floodFill4(map, 0, 0);
        System.out.println("=====================");
    }
}
