package com.whr.thread;

/**
 * @author Reed
 * @Description
 * @date 2022/8/28 13:19
 **/
//死锁：多个线程互相抱着对方需要的资源，然后形成僵持
public class DeadLock {
    public static void main(String[] args) {
        MackUp girl1 = new MackUp(0,"灰姑娘");
        MackUp girl2 = new MackUp(1,"白雪公主");
        girl1.start();
        girl2.start();
    }
}
class Lipstick{

}
class Mirror{

}
class MackUp extends Thread{
    //需要的资源只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
    int choice;//选择
    String girlName;//使用化妆品的人
    MackUp(int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }
    @Override
    public void run() {
        //化妆
        try {
            makeUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //化妆，互相持有对方的锁，就是需要拿到对方的资源
    private void makeUp() throws InterruptedException {
        if(choice==0){
            synchronized(lipstick){
                System.out.println(this.girlName+"获得口红的锁");
                Thread.sleep(1000);
            }
            synchronized(mirror){
                System.out.println(this.girlName+"获得镜子的锁");
            }
        }else {
            synchronized(mirror){
                System.out.println(this.girlName+"获得镜子的锁");
                Thread.sleep(2000);
            }
            synchronized(lipstick){
                System.out.println(this.girlName+"获得口红的锁");
            }
        }
    }
}