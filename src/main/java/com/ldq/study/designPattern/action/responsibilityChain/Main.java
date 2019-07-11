package com.ldq.study.designPattern.action.responsibilityChain;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Handler saler = HandlerFactory.createHandler();

        Random random = new Random();
        double percentPrince;
        for (int i = 0; i < 50; i++) {
            //模拟第i 个客户希望的折扣
            percentPrince = random.nextDouble();
            System.out.println("第" + i + "个库户期望的折扣：" + percentPrince);
            saler.handlerRequest(percentPrince);
        }

    }
}
