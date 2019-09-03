package com.ljaer.designpatterns.factory.abstr;


import com.ljaer.designpatterns.factory.Bmw;
import com.ljaer.designpatterns.factory.Car;

public class BmwFactory extends AbstractFactory {

	@Override
	public Car getCar() {
		return new Bmw();
	}

}
