package com.ldq.study.loadBalance;

import java.util.*;

/**
 * 加权轮询（Weight Round Robin）法
 * 不同的服务器可能机器配置和当前系统的负载并不相同，因此它们的抗压能力也不尽相同，
 * 给配置高、负载低的机器配置更高的权重，让其处理更多的请求，
 * 而低配置、高负载的机器，则给其分配较低的权重，降低其系统负载
 */
public class WeightRoundRobinSelect {
    private static Integer pos;

    public static String getServer()
    {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<>();
        serverMap.putAll(BalanceData.serverWeightMap);

        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        Iterator<String> iterator = keySet.iterator();

        /**
         * 根据权重数量，生成新的server数组，
         * 将地址重复地增加到服务器地址列表中，权重越大，该服务器每轮所获得的请求数量越多。
         * 会涉及到arrayList数组扩容的问题，损失一定的性能
         */
        List<String> serverList = new ArrayList<>();
        while (iterator.hasNext())
        {
            String server = iterator.next();
            int weight = serverMap.get(server);
            for (int i = 0; i < weight; i++)
                serverList.add(server);
        }

        String server = null;
        /**
         * 当前轮询的位置变量pos，为了保证服务器选择的顺序性，需要在操作时对其加锁，
         * 使得同一时刻只能有一个线程可以修改pos的值，否则当pos变量被并发修改，
         * 则无法保证服务器选择的顺序性，甚至有可能导致keyList数组越界。
         */
        synchronized (pos)
        {
            if (pos > keySet.size())
                pos = 0;
            server = serverList.get(pos);
            pos ++;
        }

        return server;
    }
}
