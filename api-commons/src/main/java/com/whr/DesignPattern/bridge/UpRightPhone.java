package com.whr.DesignPattern.bridge;

//直板式手机类，继承抽象类Phone
public class UpRightPhone extends Phone {
	
	//构造器
	public UpRightPhone(Brand brand) {
		super(brand);
	}

	public void open() {
		super.open();
		System.out.println("直板样式手机");
	}

	public void close() {
		super.close();
		System.out.println("直板样式手机");
	}

	public void call() {
		super.call();
		System.out.println("直板样式手机");
	}

}
