package com.tl.learn.juc.jiagou.sync;

public class Synchronized01 {

    public static synchronized void m(){}

    public static void main(String[] args) {
        synchronized (Synchronized01.class){
        }

        m();
    }

}
