package com.ljaer.designpatterns.factory.func;

import com.ljaer.designpatterns.factory.Bmw;
import com.ljaer.designpatterns.factory.Car;

public class BmwFactory implements Factory {

	@Override
	public Car getCar() {
		return new Bmw();
	}

}
