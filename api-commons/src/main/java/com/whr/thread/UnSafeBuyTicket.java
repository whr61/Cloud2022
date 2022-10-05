package com.whr.thread;

/**
 * @author Reed
 * @Description
 * @date 2022/8/27 21:42
 **/

public class UnSafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"苦逼的我").start();
        new Thread(buyTicket,"牛逼的你们").start();
        new Thread(buyTicket,"可恨的黄牛党").start();
    }
}
class BuyTicket implements Runnable {
    //票
    private int ticketNums = 10;
    //外部停止方式
    boolean flag = true;
    @Override
    public void run() {
        try {
            while (flag){
                buy();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private synchronized void buy() throws InterruptedException {
        if(ticketNums<=0){
            flag = false;
            return;
        }
        Thread.sleep(100);
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
}