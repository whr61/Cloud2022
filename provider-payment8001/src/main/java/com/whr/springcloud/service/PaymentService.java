package com.whr.springcloud.service;

import com.whr.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * @author Reed
 * @Description
 * @date 2022/7/24 00:29
 **/
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
    public List<Payment> getPagePayment(Map pageMapPara);
}
