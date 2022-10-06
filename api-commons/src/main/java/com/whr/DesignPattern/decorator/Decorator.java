package com.whr.DesignPattern.decorator;

public class Decorator extends Drink {

	private Drink obj;//被装饰者
	public Decorator(Drink obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj;
	}
	
	@Override
	public float cost() {
		// TODO Auto-generated method stub
		// getPrice自己的价格
		return super.getPrice()+obj.cost();
	}
	
	@Override
	public String getDes() {
		// TODO Auto-generated method stub
		// obj.getDes()被装饰者的信息
		return super.des+" "+super.getPrice()+" && "+obj.getDes();
	}
}
