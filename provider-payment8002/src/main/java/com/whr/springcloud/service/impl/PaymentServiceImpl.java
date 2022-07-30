package com.whr.springcloud.service.impl;

import com.whr.springcloud.dao.PaymentDao;
import com.whr.springcloud.entities.Payment;
import com.whr.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author Reed
 * @Description
 * @date 2022/7/24 00:31
            **/
    @Service
    public class PaymentServiceImpl implements PaymentService {
        @Resource
    private PaymentDao paymentDao;
    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}