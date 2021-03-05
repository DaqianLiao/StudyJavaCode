package com.ldq.study.bigdata.kfk;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParser;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ZkController implements Runnable {
    private static final String Controller_path = "/kfk/controller";
    private final String brokerId;
    private ZooKeeper zkClient;
    private String host;

    Watcher watcher = we -> {
        System.out.println("got event of /controller:" + we);

        if (we.getType() == Watcher.Event.EventType.NodeDeleted) {
            tryElectController();
        }
    };

    public ZkController(String brokerId, String host) {
        this.brokerId = brokerId;
        this.host = host;
    }


    @Override
    public void run() {
        while (true) {
            tryElectController();
            try {
                System.out.println("ZkController.run");
                try {
                    byte[] zkData = zkClient.getData(Controller_path, false, null);
                    String controllerInfo = new String(zkData, StandardCharsets.UTF_8);
                    String brokerid = JSONObject.parseObject(controllerInfo).getString("brokerid");
                    if (brokerid.equals(brokerId)) {
                        System.out.println("I am controller,do thing");
                        Thread.sleep(100000);
                    } else {
                        Thread.sleep(1000);
                    }
                } catch (KeeperException e) {
                    e.printStackTrace();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void tryElectController() {
        try {
            if (this.zkClient == null) {
                this.zkClient = new ZKConnection().connect(host);
            }

            Stat exists = zkClient.exists(Controller_path, watcher);
            if (exists == null) {
                System.out.println("no controller exists, try to be the controller ...");
                String data = String.format("{\"version\":1,\"brokerid\":%s,\"timestamp\":\"%d\"}", brokerId, System.currentTimeMillis());
//               创建controller节点，设置为临时节点格式，可能会创建失败，如果失败，则会抛出创建失败信息
                String s = zkClient.create(Controller_path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                System.out.println(s);
            } else {
                System.out.println("controller exists, " + exists.toString());
//                读取controller数据
                byte[] controllerData = zkClient.getData(Controller_path, false, null);
                String s = new String(controllerData, "UTF-8");
                System.out.println("current controller is " + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ZkController controller = new ZkController(args[0], "127.0.0.1");

        Thread thread = new Thread(controller);
        thread.start();
    }
}
