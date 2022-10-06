package com.whr.designPattern.factory.factorymethod.pizzastore.order;

import com.whr.designPattern.factory.factorymethod.pizzastore.pizza.BJCheesePizza;
import com.whr.designPattern.factory.factorymethod.pizzastore.pizza.Pizza;
import com.whr.designPattern.factory.factorymethod.pizzastore.pizza.BJPepperPizza;

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
