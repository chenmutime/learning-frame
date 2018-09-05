package com.pri.learningframe.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class CuratorClient {

    private final static String ROOT_PATH = "/lock";
    private static String zkConnectionAddr = "127.0.0.1:2181";
    private static CuratorFramework client = null;

    public static void initialize() throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.newClient(zkConnectionAddr, retryPolicy);
        client.start();
        client.checkExists().forPath(ROOT_PATH);
    }

    public static CuratorFramework getClient() {
        if (client == null) {
            throw new RuntimeException("curator client must not is null");
        }
        return client;
    }

}
