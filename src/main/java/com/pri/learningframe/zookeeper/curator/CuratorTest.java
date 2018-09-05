package com.pri.learningframe.zookeeper.curator;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CuratorTest {

    public static void main(String[] args) {
        try {
            CuratorClient.initialize();
            ExecutorService executor = Executors.newFixedThreadPool(5);
            for (int i = 0; i < 5; i++) {
                executor.submit(new Runnable() {
                    @Override
                    public void run() {
                        String lockPath = "/_lock_";
                        InterProcessMutex lock = new InterProcessMutex(CuratorClient.getClient(), lockPath);
                        try {
//                            如果等待时间为负，即一旦获取不到锁立刻返回失败；如果为正，则当前线程没有争到锁时，等待指定时间
                            if (lock.acquire(-1L, TimeUnit.SECONDS)) {
                                try {
                                    System.out.println(Thread.currentThread().getName() + "获取到锁啦！");
                                    Thread.sleep(1000);
                                } finally {
                                    try {
                                        lock.release();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }else {
                                System.out.println(Thread.currentThread().getName() + "获取锁失败！");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
