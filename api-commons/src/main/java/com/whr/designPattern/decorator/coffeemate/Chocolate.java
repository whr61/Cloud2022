package com.whr.designPattern.decorator.coffeemate;

import com.whr.designPattern.decorator.Decorator;
import com.whr.designPattern.decorator.Drink;

//具体的Decorator，这里就是调味品
public class Chocolate extends Decorator {

	public Chocolate(Drink obj) {
		super(obj);
		setDes("巧克力");
		setPrice(3.0f); //调味品的价格
	}

}
