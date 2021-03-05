package com.ldq.study.bigdata.hdfs;

import java.util.LinkedList;

public class FSImageLog {
    public long txid = 0;
    //    syncBuffer中正在处理的最大的maxTxid
    public long maxTxid = 0;
    public DoubleBufferLog doubleBufferLog = new DoubleBufferLog();
    public ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    //    当前线程是否在刷写磁盘，默认为false，表示第一次进来没有刷盘
    public boolean running = false;
    //    判断当前线程是否需要等待
    public boolean waiting = false;

    public static void main(String[] args) {
        FSImageLog fsImageLog = new FSImageLog();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        /**
                         * 通过分段加锁的方式实现内存部分加锁，刷盘部分不加锁，提高执行效率
                         * 批量写
                         */
                        fsImageLog.writeLog(Thread.currentThread().getName());
                    }
                }
            }).start();
        }
    }

    public void writeLog(String log) {
//        分段锁加锁
        synchronized (this) {
            txid++;
//           构建日志对象
            ImageLog imageLog = new ImageLog(txid, log);
//            写内存
            doubleBufferLog.write(imageLog);
            threadLocal.set(txid);
        }
//        释放分段锁
//        由于释放锁需要消耗一定时间，在高并发场景下，
//        此时有很多数据已经进入到currentBuffer中
//        每个线程都会执行flush方法，但是只有某个线程才会执行真正的flush

        System.out.println(System.currentTimeMillis() + ": " + Thread.currentThread().getName() + " read to flush");
//        执行Flush
        flushLog();
    }

    private void flushLog() {
//        分段锁加锁
        synchronized (this) {
//            由于running初始值为false，因此第一次不会走到该逻辑，
//            当有线程在执行flush操作时，此时会走到该流程
            if (running) {
                long txid = threadLocal.get();
                System.out.println("txid = " + txid);
                System.out.println("maxTxid = " + maxTxid);
                if (txid <= maxTxid) {
                    System.out.println(System.currentTimeMillis() + ": " + Thread.currentThread().getName() + " return, cause " + txid + " <= " + maxTxid);
                    return;
                }
                if (waiting) {
                    System.out.println(System.currentTimeMillis() + ": " + Thread.currentThread().getName() + " return, cause waiting = true");
                    return;
                }
                waiting = true;
//                设置等待时间，直到flush完成之后，将running修改为false
                while (running) {
                    try {
//                        释放锁
                        System.out.println(System.currentTimeMillis() + ": " +
                                Thread.currentThread().getName() + " is waiting=======");
                        this.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                waiting = false;
            }
//            每个线程第一次进来都会执行exchange方法，同时每个线程都会将running值修改为false，
//            由于加锁了，因此只有一个线程可以执行该操作

            doubleBufferLog.exchange();
            running = true;
//            会计算syncBuffer中的log数据中的最大maxtxid值
            if (doubleBufferLog.syncBuffer.size() != 0) {
                maxTxid = doubleBufferLog.getMaxTxid();
            }
        }
        //释放锁
//        把内存的数据写入到磁盘，此时未加锁，
//        因此每个线程可以利用flush的时间继续接受imageLog文件
        doubleBufferLog.flush();
        System.out.println(System.currentTimeMillis() + ": " + Thread.currentThread().getName() + " finish flush");

        synchronized (this) {
            this.notifyAll();
            running = false;
        }
    }

    public class ImageLog {
        //        事务ID
        public long txid;
        //        具体的log数据
        public String data;

        public ImageLog(long txid, String data) {
            this.txid = txid;
            this.data = data;
        }

        @Override
        public String toString() {
            return "ImageLog{" +
                    "txid =" + txid +
                    ", log =" + data +
                    '}';
        }
    }

    public class DoubleBufferLog {
        //        当前可以写入的内存队列，用来承接写入到内存的log
        private LinkedList<ImageLog> currentBuffer = new LinkedList<>();
        //       刷盘队列，把内存中的元数据写入到磁盘
        private LinkedList<ImageLog> syncBuffer = new LinkedList<>();

        /**
         * 内存写日志
         *
         * @param imageLog
         */
        public void write(ImageLog imageLog) {
            currentBuffer.add(imageLog);
        }

        /**
         * 把数据写入到磁盘
         * 通常较慢
         */
        public void flush() {
            for (ImageLog imageLog : syncBuffer) {
                System.out.println(Thread.currentThread().getName() + " is flush log: " + imageLog);
            }
//            数据写完之后，就直接清空掉syncBuffer队列
            syncBuffer.clear();
        }

        public void exchange() {
            System.out.println("currentBuffer & syncBuffer exchange");
            LinkedList<ImageLog> tmp = currentBuffer;
            currentBuffer = syncBuffer;
            syncBuffer = tmp;
        }

        //        由于事务ID是顺序递增的，因此直接获取最后一个事务就可以得到最大的事务ID
        public long getMaxTxid() {
            return syncBuffer.getLast().txid;
        }
    }
}
