package com.whr.DesignPattern.builder.improve;

public class HighBuilding extends HouseBuilder {

	@Override
	public void buildBasic() {
		// TODO Auto-generated method stub
		System.out.println("高层地基打100米");
	}

	@Override
	public void buildWalls() {
		// TODO Auto-generated method stub
		System.out.println("高层砌墙20cm");
	}

	@Override
	public void roofed() {
		// TODO Auto-generated method stub
		System.out.println("高层透明的屋顶");
	}

}
