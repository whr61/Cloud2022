package com.whr.springcloud.thread;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author Reed
 * @Description
 * @date 2022/7/31 20:22
 **/

public class TestThread2 extends Thread{
    private String url;
    private String name;
    public TestThread2(String url,String name){
        this.url = url;
        this.name = name;
    }
    @Override
    public void run(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
    }
    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("http://oa.chasesun.cn/ui-exts/header_chasesun/images/bg_scroll.jpg","1.jpg");
        TestThread2 t2 = new TestThread2("http://oa.chasesun.cn/ui-exts/header_chasesun/images/bg_scroll.jpg","1.jpg");
        TestThread2 t3 = new TestThread2("http://oa.chasesun.cn/ui-exts/header_chasesun/images/bg_scroll.jpg","1.jpg");
        t1.start();
        t2.start();
        t3.start();
    }
}

class WebDownloader{
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常,downloader方法出现问题");
        }
    }
}