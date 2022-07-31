package com.whr.springcloud.interfacetest;

/**
 * @author Reed
 * @version 1.0
 * @date 2021/11/7 20:58
 */
public class WesternCooker implements FoodMenu{

    @Override
    public void shiZiChaoJiDan() {
        System.out.println("Scrambled eggs with tomatoes made by a Western Chef");
    }

    @Override
    public void yuXiangRousi() {
        System.out.println("Fish flavored shredded pork cooked by a Western Chef ");
    }
}
