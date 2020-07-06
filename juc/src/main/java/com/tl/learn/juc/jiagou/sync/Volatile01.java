package com.tl.learn.juc.jiagou.sync;

import java.util.concurrent.*;

public class Volatile01 {

    volatile boolean stop = false;
    public void doWork(){
        while (!stop){
        }
        System.out.println("你能读到我吗。。。");
    }

    public void shutDown(){
        stop = true;
    }

    public static void main(String[] args) throws InterruptedException {
        Volatile01 volatile01 = new Volatile01();
        new Thread(()->{
            volatile01.doWork();
        }).start();
        Thread.sleep(1000);
        new Thread(()->{
            volatile01.shutDown();
        }).start();

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("12222");
            }
        });


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        },0,3, TimeUnit.SECONDS);


    }

}
