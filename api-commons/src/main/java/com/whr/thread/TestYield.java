package com.whr.thread;

/**
 * @author Reed
 * @Description 礼让线程，让当前正在执行的线程暂停，但不阻塞
 * 讲线程从运行状态转为就绪状态
 * 让cpu重新调度，礼让不一定成功
 * @date 2022/8/27 19:45
 **/

public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }
}

class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程停止执行");
    }
}