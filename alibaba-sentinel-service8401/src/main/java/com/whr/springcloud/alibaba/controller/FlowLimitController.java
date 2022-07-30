package com.whr.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Reed
 * @Description
 * @date 2022/7/29 21:26
 **/
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        try{
            TimeUnit.MILLISECONDS.sleep(800);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return "---------testA";
    }
    @GetMapping("/testB")
    public String testB(){
        return "---------testB";
    }
}