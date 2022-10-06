package com.whr.DesignPattern.decorator.coffeemate;

import com.whr.DesignPattern.decorator.Decorator;
import com.whr.DesignPattern.decorator.Drink;

public class Soy extends Decorator {
	public Soy(Drink obj) {
		super(obj);
		// TODO Auto-generated constructor stub
		setDes("豆浆");
		setPrice(1.5f);
	}
}
