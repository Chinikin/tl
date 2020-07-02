package com.tl.learn.juc.jiagou.sync;

import java.util.concurrent.locks.ReentrantLock;

public class ReentranLock01 implements Runnable{

    static int i = 0;
    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ReentranLock01 r = new ReentranLock01();
        Thread t = new Thread(r);
        Thread t2 = new Thread(r);
        t.start();
        t2.start();

        System.out.println(i);

    }

    public  void add(){

        try {
            lock.lockInterruptibly();
            for(;;){
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }
    }

    @Override
    public void run() {
        add();
    }
}
