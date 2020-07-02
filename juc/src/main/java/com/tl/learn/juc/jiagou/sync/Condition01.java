package com.tl.learn.juc.jiagou.sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Condition01 {

    private static int count = 0;
    static ReentrantLock lock = new ReentrantLock();
    static Condition full = lock.newCondition();
    static Condition empty = lock.newCondition();

    public static void main(String[] args) {
        new Thread(()->{
            producer();
        }).start();

        new Thread(()->{
            consumer();
        }).start();

    }


    public static void producer(){
        try {
            lock.lock();
            for (;;){
                count++;
                System.out.println("增加：" + count);
                if(count >= 30){
                    System.out.println("等待中。。。");
                    Thread.sleep(1000);
                    full.await();
                    empty.signal();
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void consumer(){
        try {
            lock.lock();
            for (;;){
                count--;
                System.out.println("减少：" + count);
                if(count <= 0){
                    System.out.println("等待中。。。");
                    Thread.sleep(1000);
                    full.signal();
                    empty.await();
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
