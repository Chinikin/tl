package com.tl.learn.juc.jiagou.collect;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public static final Map<String,String> map = new HashMap();

    public static void main(String[] args) {
        new Thread(()->{
           for (int i = 0; i<1000; i++){
               map.put(String.valueOf(i),String.valueOf(i));
           }
        }).start();

        new Thread(()->{
            for (int j = 1000; j<2000; j++){
                map.put(String.valueOf(j),String.valueOf(j));
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0 ;i<2000;i++){
            System.out.println("第" + i + "元素值：" + map.get(String.valueOf(i)));
        }


    }

}
