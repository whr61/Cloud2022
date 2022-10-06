package com.whr.designPattern.builder.improve;

public class Client {
	public static void main(String[] args) {
		//盖普通房子
		CommonHouse commonHouse = new CommonHouse();
		HouseDirector houseDirector = new HouseDirector(commonHouse);
		House house = houseDirector.constructHouse();
		System.out.println("------------------------------");
		//盖高层
		HighBuilding highBuilding = new HighBuilding();
		houseDirector.setHouseBuilder(highBuilding);
		houseDirector.constructHouse();
	}
}
