package com.whr.thread;

/**
 * @author Reed
 * @Description
 * @date 2022/8/2 19:43
 **/

public class TestThread4 implements Runnable{
    private int tickerNums = 10;
    @Override
    public void run(){
        while (true){
            if(tickerNums<=0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"---->拿到了第"+tickerNums--+"票");
        }
    }

    public static void main(String[] args) {
        TestThread4 ticket = new TestThread4();
        new Thread(ticket,"张三").start();
        new Thread(ticket,"李四").start();
        new Thread(ticket,"王五").start();
    }
}