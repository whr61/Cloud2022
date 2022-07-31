package com.whr.springcloud.interfacetest;

/**
 * @author Reed
 * @version 1.0
 * @date 2021/11/7 21:11
 */
public class Test {
    public static void main(String[] args) {
        FoodMenu foodMenu = new ChinaCooker();
        Customer customer = new Customer(foodMenu);
        customer.order();
    }
}
