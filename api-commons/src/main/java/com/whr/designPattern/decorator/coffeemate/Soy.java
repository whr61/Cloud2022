package com.whr.designPattern.decorator.coffeemate;

import com.whr.designPattern.decorator.Decorator;
import com.whr.designPattern.decorator.Drink;

public class Soy extends Decorator {
	public Soy(Drink obj) {
		super(obj);
		// TODO Auto-generated constructor stub
		setDes("豆浆");
		setPrice(1.5f);
	}
}
