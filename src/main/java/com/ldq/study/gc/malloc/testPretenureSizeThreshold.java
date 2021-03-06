package com.ldq.study.gc.malloc;

public class testPretenureSizeThreshold {
    private static final int _1MB = 1024 * 1024;

    /**
     * 需要显示指定SerialGC，可以更清楚看得到效果
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728 -XX:+UseSerialGC
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];  //直接分配在老年代中
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
