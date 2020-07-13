package com.tl.learn.juc.jiagou.recursiveaction;

import com.tl.learn.juc.jiagou.utils.Utils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MyTest extends RecursiveTask<Long> {
    int start;
    int max = 10;
    int end;
    int[] arr;

    public MyTest(int start,int end,int[] arr){
        this.start = start;
        this.end = end;
        this.arr = arr;
    }
    @Override
    protected Long compute() {
        long sum = 0;
        if(end - start < max){
            for(int i = start;i<max;i++){
                sum+=arr[i];
            }
         return sum;
        }else {
            int mid = start + (end - start) / 2;
            MyTest left = new MyTest(start,mid,arr);
            MyTest right = new MyTest(mid+1,end,arr);
            left.fork();
            right.fork();
           return left.join() + right.join();
        }

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       /* ForkJoinPool pool = new ForkJoinPool();
        MyTest test = new MyTest(0,1000, Utils.buildRandomIntArray(1000));
        pool.execute(test);
        System.out.println(test.get());*/
        System.out.println(fb(6));
    }


    public static int fb(int index){
        int i = 1;
        int j = 1;
        int num = 0;
        if(index > 2){

            for(int k = 0;k < index - 2;k++){
                num = i + j;
                i=j;
                j=num;
                System.out.println("i:" + i);
                System.out.println("j:" + j);
            }
        }
        return num;
    }
}
