package com.whr.DesignPattern.decorator.coffeemate;

import com.whr.DesignPattern.decorator.Decorator;
import com.whr.DesignPattern.decorator.Drink;

public class Milk extends Decorator {
	public Milk(Drink obj) {
		super(obj);
		// TODO Auto-generated constructor stub
		setDes("牛奶");
		setPrice(2.0f); 
	}
}
