package com.whr.springcloud.interfacetest;

/**
 * @author Reed
 * @version 1.0
 * @date 2021/11/7 20:57
 */
public class ChinaCooker implements FoodMenu{

    @Override
    public void shiZiChaoJiDan() {
        System.out.println("中餐厨师做的西红柿炒鸡蛋！");
    }

    @Override
    public void yuXiangRousi() {
        System.out.println("中餐厨师做的鱼香肉丝！");
    }
}
