package com.ljaer.designpatterns.template;

public class Tea extends Bevegrage{

	//原材料放到杯中
	public void pourInCup() {
		System.out.println("将茶叶放入杯中");
	}

	//放辅料
	public void addCoundiments() {
		System.out.println("添加蜂蜜");
	}

}

