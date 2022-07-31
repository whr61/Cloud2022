package com.whr.springcloud.interfacetest;

/**
 * @author Reed
 * @version 1.0
 * @date 2021/11/7 20:57
 * has a来描述 统一以属性形式存在
 * is a都可以以继承形式存在
 */
public class Customer {
    FoodMenu foodMenu;
    public FoodMenu getFoodMenu() {
        return foodMenu;
    }
    public void setFoodMenu(FoodMenu foodMenu) {
        this.foodMenu = foodMenu;
    }
    public Customer(){
    }
    public Customer(FoodMenu foodMenu){
        this.foodMenu = foodMenu;
    }
    public void order(){
        this.getFoodMenu().shiZiChaoJiDan();
        this.getFoodMenu().yuXiangRousi();
    }
}
