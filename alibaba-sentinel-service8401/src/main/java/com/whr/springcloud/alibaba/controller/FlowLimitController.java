package com.whr.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Reed
 * @Description
 * @date 2022/7/29 21:26
 **/
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        return "---------testA";
    }
    @GetMapping("/testB")
    public String testB(){
        return "---------testB";
    }
}