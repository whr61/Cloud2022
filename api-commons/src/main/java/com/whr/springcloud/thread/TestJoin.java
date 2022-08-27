package com.whr.springcloud.thread;

/**
 * @author Reed
 * @Description
 * @date 2022/8/27 19:54
 **/

public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程VIP来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        //启动我们的线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 500; i++) {
            if(i==200){
                //我们的线程插队
                thread.join();
            }
            System.out.println("main"+i);
        }
    }
}