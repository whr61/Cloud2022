package com.whr.DesignPattern.factory.factorymethod.pizzastore.order;

import com.whr.DesignPattern.factory.factorymethod.pizzastore.pizza.BJCheesePizza;
import com.whr.DesignPattern.factory.factorymethod.pizzastore.pizza.Pizza;
import com.whr.DesignPattern.factory.factorymethod.pizzastore.pizza.BJPepperPizza;

public class BJOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        // TODO Auto-generated method stub
        return pizza;
    }
}
