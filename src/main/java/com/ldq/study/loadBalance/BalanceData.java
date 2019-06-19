package com.ldq.study.loadBalance;

import java.util.HashMap;

public class BalanceData {
    public static final HashMap<String,Integer> serverWeightMap=new HashMap<>();

    static{
      serverWeightMap.put("192.168.0.100",1);
      serverWeightMap.put("192.168.0.101",1);

      serverWeightMap.put("192.168.0.102",2);
      serverWeightMap.put("192.168.0.103",2);
      serverWeightMap.put("192.168.0.104",3);
      serverWeightMap.put("192.168.0.105",3);
      serverWeightMap.put("192.168.0.106",3);
      serverWeightMap.put("192.168.0.107",4);
      serverWeightMap.put("192.168.0.108",4);
      serverWeightMap.put("192.168.0.109",5);

    }
}
