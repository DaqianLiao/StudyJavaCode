package com.ldq.study.loadBalance;

public class LoadBalanceMain {

    public static void main(String[] args) {
        System.out.println("原始数据" + BalanceData.serverWeightMap);

        System.out.println(HashSelect.getServer());
        System.out.println(RandomSelect.getServer());
        System.out.println(RoundRobinSelect.getServer());
        System.out.println(WeightRandomSelect.getServer());
        System.out.println(WeightRoundRobinSelect.getServer());
    }
}
