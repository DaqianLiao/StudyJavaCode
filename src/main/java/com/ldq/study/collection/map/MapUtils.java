package com.ldq.study.collection.map;

public class MapUtils {

    private static int MAXIMUM_CAPACITY = 2 ^ 16;

    /**
     * 找到一个数最近的cap的2的幂次方
     *
     * @param cap
     * @return
     */
    public static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    /**
     * 计算key值的hashcode
     *
     * @param key
     * @return
     */
    public static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void testSizeFor() {
        int num = 13;
        System.out.println(num >> 1);
        System.out.println(num >>> 1);
        System.out.println(num >>> 1 | num);
        num = -13;
        System.out.println(num >> 1);
        System.out.println(num >>> 1);
        System.out.println(tableSizeFor(7));
        System.out.println(tableSizeFor(8));
        System.out.println(tableSizeFor(13));
        System.out.println(tableSizeFor(16));
    }

    /**
     * 如果高16位全部为0，则异或（相同为0，不同为1）结果就等于自身
     */
    public static void testHash() {
        Integer num = 10;
        System.out.println("num = " + num + ", hashCode = " + hash(num));
        System.out.println("=======计算逻辑=======");

        int hashCode = num.hashCode();
        System.out.println("Integer hashCode value = " + hashCode);
        int high = hashCode >>> 16;
        System.out.println("right left 16 position = " + (high));
        System.out.println("hashcode xor high ans  = " + (hashCode ^ high));
    }


    /**
     * hashcode mod tableLength
     * 求模运算，比较费时，转化为位运算，效果快
     * 当length为2次幂的数据，可以key % length = key & (length - 1)
     *
     * @param hashCode
     * @param tableLength
     * @return
     */
    public static void index(int hashCode, int tableLength) {
        System.out.println("hascode % length = " + (hashCode % tableLength));
        System.out.println("mod value = " + (hashCode & (tableLength - 1)));
    }

    public static void testIndex() {
        index(10, 8);
    }

    public static void main(String[] args) {
        testHash();
        testIndex();
    }


}
