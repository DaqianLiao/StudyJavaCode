package com.ldq.study.loadBalance;

import java.util.*;

/**
 * 加权随机（Weight Random）法
 * 随机法和加权轮询法的结合
 */
public class WeightRandomSelect {

    public static String getServer() {
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
        while (iterator.hasNext()) {
            String server = iterator.next();
            int weight = serverMap.get(server);
            for (int i = 0; i < weight; i++)
                serverList.add(server);
        }

        Random random = new Random();
        int randomPos = random.nextInt(serverList.size());

        return serverList.get(randomPos);
    }
}
