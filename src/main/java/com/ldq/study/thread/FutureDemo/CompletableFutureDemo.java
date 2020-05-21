package com.ldq.study.thread.FutureDemo;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;


/**
 * CompletableFuture 使用详解
 * https://www.jianshu.com/p/6bac52527ca4
 */
public class CompletableFutureDemo {
    /**
     * runAsync方法不支持返回值
     * 默认使用ForkJoinPool.commonPool() 作为它的线程池执行异步代码
     */
    public static void runAsync() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " run end ...");
        });

        System.out.println("no return value = " + future.get());
    }

    //supplyAsync可以支持返回值
    public static void supplyAsync() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " run end ...");
            return System.currentTimeMillis();
        });

        long time = future.get();
        System.out.println("future result = " + time);
    }

    /**
     * 执行当前任务的线程执行继续执行 whenComplete 的任务
     *
     * @throws Exception
     */
    public static void whenComplete() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            if (new Random().nextInt() % 2 >= 0) {
                int i = 12 / 0;
            }
            System.out.println(Thread.currentThread().getName() + " run end ...");
        });

        future.whenComplete((t, action) -> System.out.println(Thread.currentThread().getName() + " 执行完成！"));
        future.exceptionally(t -> {
            System.out.println(Thread.currentThread().getName() + " 执行失败！" + t.getMessage());
            return null;
        });

        TimeUnit.SECONDS.sleep(2);
    }

    /**
     * 把 whenCompleteAsync 这个任务继续提交给线程池来进行执行
     *
     * @throws Exception
     */
    public static void whenCompleteAsync() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
            }
            if (new Random().nextInt() % 2 >= 0) {
                int i = 12 / 0;
            }
            System.out.println(Thread.currentThread().getName() + " run end ...");
        });

        future.whenCompleteAsync((t, action) -> System.out.println(Thread.currentThread().getName() + "执行完成！"));
        future.exceptionally(t -> {
            System.out.println(Thread.currentThread().getName() + " 执行失败！" + t.getMessage());
            return null;
        });

        TimeUnit.SECONDS.sleep(2);
    }

    /**
     * Function<? super T,? extends U>
     * T：上一个任务返回结果的类型
     * U：当前任务的返回值类型
     * thenApply 只可以执行正常的任务，任务出现异常则不执行 thenApply 方法。
     *
     * @throws Exception
     */
    private static void thenApply() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            long result = new Random().nextInt(100);
            System.out.println("result1 = " + result);
            return result;
        }).thenApply(t -> {
            long result = t * 5;
            System.out.println("t1 = " + t + ", result2 = " + result);
            return result;
        });

        long result = future.get();
        System.out.println(result);
    }

    /**
     * 当thenApply主体程序运行异常时，thenApply后面不会运行
     *
     * @throws Exception
     */
    private static void thenApplyWithException() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            long result = new Random().nextInt(100);
            System.out.println("result1 = " + result);
            return result / 0;
        }).thenApply(t -> {
            long result = t * 5;
            System.out.println("t1 = " + t + ", result2 = " + result);
            return result;
        });

        long result = future.get();
        System.out.println(result);
    }

    /**
     * handle 方法和 thenApply 方法处理方式基本一样。
     * 不同的是 handle 是在任务完成后再执行，还可以处理异常的任务
     *
     * @throws Exception
     */
    public static void handle() throws Exception {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int i = 10 / 0;
            return new Random().nextInt(10);
        }).handle((param, throwable) -> {
            int result = -1;
            if (throwable == null) {
                result = param * 2;
            } else {
                System.out.println(throwable.getMessage());
            }
            return result;
        });
        System.out.println("future result = " + future.get());
    }

    /**
     * 两个 CompletionStage 的任务都执行完成后，把两个任务的结果一块交给 thenCombine 来处理
     *
     * @throws Exception
     */
    private static void thenCombine() throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "world");
        CompletableFuture<String> result = future1.thenCombine(future2, (t, u) -> t + " " + u);
        System.out.println("future result = " + result.get());
    }

    /**
     * 当两个 CompletionStage 都执行完成后，把结果一块交给thenAcceptBoth来进行处理
     *
     * @throws Exception
     */
    private static void thenAcceptBoth() throws Exception {
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> {
            int t = new Random().nextInt(3);
            try {
                System.out.println("thread: " + Thread.currentThread().getName() + " sleep " + t + "s");
                TimeUnit.SECONDS.sleep(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("f1=" + t);
            return t;
        });

        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> {
            int t = new Random().nextInt(3);
            try {
                System.out.println("thread: " + Thread.currentThread().getName() + " sleep " + t + "s");
                TimeUnit.SECONDS.sleep(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("f2=" + t);
            return t;
        });
        f1.thenAcceptBoth(f2, (t, u) -> System.out.println("f1 = " + t + "; f2 = " + u + ";"));
    }

    public static void main(String[] args) throws Exception {

        runAsync();
        supplyAsync();
        System.out.println("___________________");
        whenComplete();
        whenCompleteAsync();
        System.out.println("___________________");
        thenApply();
        try {
            thenApplyWithException();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("___________________");
        handle();
        System.out.println("___________________");
        thenCombine();
        thenAcceptBoth();

    }
}
