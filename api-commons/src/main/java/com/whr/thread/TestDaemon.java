package com.whr.thread;

/**
 * @author Reed
 * @Description
 * 线程分用户线程和守护线程
 * 虚拟机必须确保用户线程执行完毕
 * 虚拟机不用等待守护线程执行完毕
 * @date 2022/8/27 21:01
 **/

public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        People people = new People();
        Thread thread = new Thread(god);
        thread.setDaemon(true);//默认为false表示是用户线程
        thread.start();//守护进程启动
        new Thread(people).start();

    }
}
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝保护着你");
        }
    }
}
class People implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着");
        }
        System.out.println("=====goodbye!world!=====");
    }
}