package com.whr.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Reed
 * @Description
 * @date 2022/8/27 19:33
 **/

public class TestSleep2 {

    public static void tenDown() throws InterruptedException{
        int num = 10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if(num<=0){
                break;
            }
        }
    }

    public static void sysDate() throws InterruptedException{
        Date startTime =  new Date(System.currentTimeMillis());
        while (true){
            try{
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime =  new Date(System.currentTimeMillis());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try{
//            tenDown();
            sysDate();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}