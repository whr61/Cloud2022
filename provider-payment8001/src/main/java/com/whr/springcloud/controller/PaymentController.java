package com.whr.springcloud.controller;

import com.whr.springcloud.entities.CommonResult;
import com.whr.springcloud.entities.Payment;
import com.whr.springcloud.service.PaymentService;
import com.whr.springcloud.util.CreateThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

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
    @Resource
    private DiscoveryClient discoveryClient;

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

    @RequestMapping(value = "/getPagePayment")
    public CommonResult getPagePayment(@RequestBody Map<String,Integer> pageMapPara){
        List<Payment> paymentList = paymentService.getPagePayment(pageMapPara);
        log.info("**********查询成功："+paymentList.get(0));
        if(paymentList!=null){
            return new CommonResult(200,"查询成功,查询ID:"+serverPort,paymentList.get(0));
        }else{
            return new CommonResult(444,"查询失败,查询ID:"+serverPort,null);
        }
    }

    @GetMapping(value="/queryByThread")
    public CommonResult queryByThread() {
        // 数据集合大小，由调用者自己指定
        int listSize = 1000000;
        // 开启的线程数
        int runSize = 50;
        // 一个线程处理数据条数
        int count = listSize / runSize;
        // 创建一个线程池，数量和开启线程的数量一样
        ExecutorService executor = CreateThreadUtil.createThread(runSize);
        // 计算sql语句中每个分页查询的起始和结束数据下标
        // 循环创建线程
        //此处调用具体的查询方法
        System.out.println("开始查询");
        HashMap paraMap = new HashMap();
        for (int i = 0; i < runSize; i++) {
            int index = i * count;
            int num = count;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    //查询的结果如何保存下来，会不会存在覆盖的问题
                    paraMap.put("startIndex",index);
                    paraMap.put("pageSize",num);
                    List<Payment> paymentList = paymentService.getPagePayment(paraMap);
                    System.out.println(paymentList.get(0).getSerial());
                }
            });
        }
        // 执行完关闭线程池
        executor.shutdown();
        return new CommonResult(200,"多线程处理完成");
    }

    @GetMapping(value="/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String element:services){
            log.info("*****element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        for(ServiceInstance instance:instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try{
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }
}