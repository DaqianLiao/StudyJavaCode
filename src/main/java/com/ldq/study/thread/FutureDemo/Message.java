package com.ldq.study.thread.FutureDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Message {
    //创建固定大小为100 的线程池

    private static ExecutorService service = Executors.newFixedThreadPool(100);

    //完成发送消息

    private int sendMsg(Integer receiver, String content) {
        //模拟被2整除，即为发送成功
        return receiver % 2;

    }

//发送消息的业务逻辑方法

    public int sendMsg(List<Integer> receivers, String content) {

        long begin = System.nanoTime();

//        AtomicInteger ai = new AtomicInteger(0);
        int ai = 0;

        List<Future<Integer>> list = new ArrayList<>();

        //循环发送消息

        for (int i = 0; i < receivers.size(); i++) {
            Integer receiver = receivers.get(i);

            //使用Future，Callable实现发送消息后返回发送结果
            Future<Integer> future = service.submit(() -> {
                //调用相对比较耗时的发送消息接口
                Thread.sleep(200);

                //发送消息
                int resultStatus = sendMsg(receiver, content);

                System.out.println("接收者【" + receiver + "】,发送结果【" + resultStatus + "】");

                return resultStatus;

            });

            list.add(future);

        }

        System.out.println("---------------" + (System.nanoTime() - begin) / 1000_000d + "---------------");

//循环接收发送结果，相当于一个使线程同步的过程，这个过程是比较耗时的

        for (int i = 0; i < list.size(); i++) {
            try {
                int resultStatus = list.get(i).get();
                if (resultStatus == 0) {//发送成功
//                    ai.incrementAndGet();
                    ai++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("发送消息结束，耗时：" + (System.nanoTime() - begin) / 1000_000d);

//        return ai.get();
        return ai;
    }

    public static void main(String[] args) {

        Message pmt = new Message();
        //待接收人
        List<Integer> receivers = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//
//            receivers.add(i);
//
//        }

//        生成1000个接受人员
        Stream.iterate(0, x -> x = x + 1)
                .limit(1000).forEach(receivers::add);

        String content = "群发消息_测试代码";
        int successCount = pmt.sendMsg(receivers, content);
        System.out.println("共有【" + receivers.size() + "】接收者，发送成功【" + successCount + "】");
        service.shutdown();

    }

}
