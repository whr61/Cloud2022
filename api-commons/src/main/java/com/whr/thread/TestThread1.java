package com.whr.thread;

/**
 * @author Reed
 * @Description
 * @date 2022/7/31 20:08
 **/

public class TestThread1 extends Thread{
    @Override
    public void run(){
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码---"+i);
        }
    }
    public static void main(String[] args) {
        TestThread1 testThread1 = new TestThread1();
        testThread1.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程---"+i);
        }
    }
}