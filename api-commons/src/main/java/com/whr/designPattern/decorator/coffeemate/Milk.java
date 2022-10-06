package com.whr.designPattern.decorator.coffeemate;

import com.whr.designPattern.decorator.Decorator;
import com.whr.designPattern.decorator.Drink;

public class Milk extends Decorator {
	public Milk(Drink obj) {
		super(obj);
		// TODO Auto-generated constructor stub
		setDes("牛奶");
		setPrice(2.0f); 
	}
}
