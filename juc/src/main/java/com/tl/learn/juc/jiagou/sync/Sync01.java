package com.tl.learn.juc.jiagou.sync;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sync01 implements Runnable{
    static AtomicInteger i = new AtomicInteger(0);
    ReentrantLock lock = new ReentrantLock();
    private  void add(){
        {
            for (int j = 0; j < 100000; j++) {
                i.getAndIncrement();
            }
        }
    }

    @Override
    public void run() {
        add();
    }

    public static void main(String[] args) throws InterruptedException {
        Sync01 s1 = new Sync01();
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s1);
        t1.start();
        t2.start();
        //t1.join();
       // t2.join();
        Thread.sleep(1000);
        System.out.println(i);


    }
}
