package com.whr.DesignPattern.adapter.classadapter;

//适配器类
public class VoltageAdapter extends Voltage220V implements IVoltage5V {

	@Override
	public int output5V() {
		// TODO Auto-generated method stub
		//获取到220V电压
		int srcV = output220V();
		//目标电压
		int dstV = srcV / 44 ;
		return dstV;
	}

}
