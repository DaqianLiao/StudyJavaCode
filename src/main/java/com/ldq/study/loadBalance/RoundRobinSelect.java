package com.ldq.study.loadBalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 轮询（Round Robin）法
 * <p>
 * 轮询法的优点在于：试图做到请求转移的绝对均衡。
 * <p>
 * 轮询法的缺点在于：为了做到请求转移的绝对均衡，必须付出相当大的代价，
 * 因为为了保证pos变量修改的互斥性，需要引入重量级的悲观锁synchronized，
 * 这将会导致该段轮询代码的并发吞吐量发生明显的下降。
 */
public class RoundRobinSelect {

    private static Integer pos = 0;

    public static String getServer() {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap =
                new HashMap<>();
        serverMap.putAll(BalanceData.serverWeightMap);

        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);

        String server = null;
        /**
         * 当前轮询的位置变量pos，为了保证服务器选择的顺序性，需要在操作时对其加锁，
         * 使得同一时刻只能有一个线程可以修改pos的值，否则当pos变量被并发修改，
         * 则无法保证服务器选择的顺序性，甚至有可能导致keyList数组越界。
         */
        synchronized (pos) {
            if (pos > keySet.size()) {
                pos = 0;
            }
            server = keyList.get(pos);
            pos++;

        }

        return server;
    }
}
