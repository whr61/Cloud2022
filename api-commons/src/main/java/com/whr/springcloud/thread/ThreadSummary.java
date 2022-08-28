package com.whr.springcloud.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Reed
 * @Description
 * @date 2022/8/28 19:42
 **/

public class ThreadSummary {
    public static void main(String[] args) {
        new MyThread1().start();
        new Thread(new MyThread2()).start();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread3());
        new Thread(futureTask).start();
        try{
            Integer integer = futureTask.get();
            System.out.println(integer);
        }catch(InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
    }
}
//1.继承Thread类
class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread1");
    }
}
//2.实现Runnable接口
class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("MyThread2");
    }
}
//3.实现Callable接口
class MyThread3 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("MyThread3");
        return 100;
    }
}