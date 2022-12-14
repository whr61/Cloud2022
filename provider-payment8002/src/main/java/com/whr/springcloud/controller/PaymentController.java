package com.whr.springcloud.controller;

import com.whr.springcloud.entities.CommonResult;
import com.whr.springcloud.entities.Payment;
import com.whr.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * @author Reed
 * @Description
 * @date 2022/7/24 00:35
 **/
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("**********插入成功："+result);
        if(result>0){
            return new CommonResult(200,"插入数据库成功",result);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("**********查询成功："+payment);
        if(payment!=null){
            return new CommonResult(200,"查询成功,查询ID:"+serverPort,payment);
        }else{
            return new CommonResult(444,"查询失败,查询ID:"+serverPort,null);
        }
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}