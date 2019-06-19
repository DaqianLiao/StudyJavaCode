package com.ldq.study.loadBalance;

import java.util.*;

/**
 * 随机（Random）法
 * 根据后端服务器列表的大小值来随机选择其中一台进行访问
 *
 * 在选取server的时候，通过Random的nextInt方法取0~keyList.size()区间的一个随机值，
 * 从而从服务器列表中随机获取到一台服务器地址进行返回。
 * 基于概率统计的理论，吞吐量越大，随机算法的效果越接近于轮询算法的效果。
 */

public class RandomSelect {
    public static String getServer(){
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap =
                new HashMap<>();
        serverMap.putAll(BalanceData.serverWeightMap);

        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);


        Random random = new Random();
        int pos = random.nextInt(keyList.size());
        return keyList.get(pos);
    }

}
