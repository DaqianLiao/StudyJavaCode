package com.ldq.study.thread.pool.start;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SubmitExecute {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testSubmit();
        System.out.println("==========");
        try {
            testExecute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("+++++++++++++++");
        testFuture();
    }

    /**
     * 通过future获取任务的运行结果，正常结果和异常都属于运行结果
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void testFuture() throws ExecutionException, InterruptedException {
        List<Integer> integerList = Lists.newArrayList(1, 2, 3, null);
        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.submit(() -> {
            integerList.parallelStream().map(a -> a.toString()).collect(Collectors.toList());
        }).get();
        pool.shutdown();
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * submit将传进去的任务重新封装成callable接口，可以获得返回值
     * 但是如果没有获取返回值，是不能盘的出任务是否成功的
     *
     * @throws InterruptedException
     */
    private static void testSubmit() throws InterruptedException {
        List<Integer> integerList = Lists.newArrayList(1, 2, 3, null);
        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.submit(() -> {
            integerList.parallelStream().map(a -> a.toString()).collect(Collectors.toList());
        });
        pool.shutdown();

        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * execute方式运行线程池，有任何异常都会直接抛出
     *
     * @throws InterruptedException
     */
    private static void testExecute() throws InterruptedException {
        List<Integer> integerList = Lists.newArrayList(1, 2, 3, null);
        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.execute(() -> {
            integerList.parallelStream().map(a -> a.toString()).collect(Collectors.toList());
        });
        pool.shutdown();

        TimeUnit.SECONDS.sleep(1);
    }
}
