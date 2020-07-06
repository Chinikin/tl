package com.tl.learn.juc.jiagou.sync;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class EnumDemo {
    private int r=0;

    private EnumDemo(){
    }

    private enum  SingleEnum{
        SINGLE_ENUM;
        private EnumDemo enumDemo;
        private SingleEnum(){
            enumDemo = new EnumDemo();
        }

        public EnumDemo getEnumDemo(){
            return enumDemo;
        }
    }

    public static EnumDemo getEnumDemo2(){
        return SingleEnum.SINGLE_ENUM.getEnumDemo();
    }

    public static void main(String[] args) {
        EnumDemo e =EnumDemo.getEnumDemo2();


        Set s = new HashSet();
        for(int i=0;i<100;i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    s.add(EnumDemo.getEnumDemo2().hashCode());
                }
            });
            t.start();
        }

        System.out.println(s.size());
    }

}
