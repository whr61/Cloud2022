package com.whr.springcloud.thread;

/**
 * @author Reed
 * @Description
 * @date 2022/8/27 22:07
 **/

public class UnSafeBank {
    public static void main(String[] args) {
        Account account = new Account(100,"结婚基金");
        Drawing you = new Drawing(account,50,"你");
        Drawing girlFriend =  new Drawing(account,100,"女朋友");
        you.start();
        girlFriend.start();
    }
}
//账户
class Account{
    int money;//余额
    String name;//卡名
    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
//银行:模拟取款
class Drawing extends Thread{
    //账户
    Account account;
    //取了多少钱
    int drawingMoney;
    //手上的钱
    int nowMoney;
    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
    //取钱
    @Override
    public void run(){
        //锁变化量
        synchronized(account){
            //判断有没有钱
            if(account.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money = account.money-drawingMoney;
            nowMoney = nowMoney+drawingMoney;
            System.out.println(account.name+"余额为:"+account.money);
            //Thread.currentThread().getName()=this.getName()
            System.out.println(this.getName()+"手里的钱:"+nowMoney);
        }
    }
}