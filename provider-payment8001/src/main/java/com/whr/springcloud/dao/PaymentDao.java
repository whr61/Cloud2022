package com.whr.springcloud.dao;

import com.whr.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Reed
 * @Description
 * @date 2022/7/24 00:08
 **/
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
    public List<Payment> getPagePayment(Map pageMapPara);
}
