package com.whr.DesignPattern.decorator;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//装饰这模式下的订单：两份巧克力+一份牛奶的LongBlack

		// 1.点一份LongBlack
		Drink order = new LongBlack();
		System.out.println("费用1=" + order.cost());
		System.out.println("描述=" + order.getDes());

		// 2.order加入一份牛奶
		order = new Milk(order);

		System.out.println("order加入一份牛奶的费用=" + order.cost());
		System.out.println("order加入一份牛奶的描述=" + order.getDes());

		// 3.order加入一份巧克力

		order = new Chocolate(order);

		System.out.println("order加入一份牛奶+加入一份巧克力的费用=" + order.cost());
		System.out.println("order加入一份牛奶+加入一份巧克力的描述=" + order.cost());

		// 3.order又加入一份巧克力

		order = new Chocolate(order);

		System.out.println("order加入一份牛奶+加入一份巧克力+加入一份巧克力的费用=" + order.cost());
		System.out.println("order加入一份牛奶+加入一份巧克力+加入一份巧克力的描述=" + order.cost());
	
		System.out.println("======================================================");
		
		Drink order2 = new DeCaf();

		System.out.println("order2无因咖啡的费用=" + order2.cost());
		System.out.println("order2无因咖啡的描述= " + order2.getDes());
		
		order2 = new Milk(order2);
		
		System.out.println("order2无因咖啡加入一份牛奶的费用=" + order2.cost());
		System.out.println("order2无因咖啡加入一份牛奶的描述= " + order2.getDes());
	
	}

}
