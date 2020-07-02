package com.tl.learn.juc.jiagou.sync;

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
    }

}
