package com.ldq.study.bigdata.kfk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;


import java.util.concurrent.CountDownLatch;

public class ZKConnection {
    private final CountDownLatch countDownLatch = new CountDownLatch(1);

    private ZooKeeper zkClient;
    public ZooKeeper connect(String host) throws Exception {
        zkClient = new ZooKeeper(host,2182,
                we -> {
                    if (we.getState() == Watcher.Event.KeeperState.SyncConnected) {
                        System.out.println("zk connected.");
                        countDownLatch.countDown();
                    } else if (we.getState() == Watcher.Event.KeeperState.Disconnected) {
                        System.out.println("zk disconnected connected.");
                    } else if (we.getState() == Watcher.Event.KeeperState.Expired) {
                        System.out.println("zk session expired.");
                    }
                }
        );
        countDownLatch.await();
        return  zkClient;
    }

}
