package com.ljaer.designpatterns.factory.abstr;

import com.ljaer.designpatterns.factory.Benz;
import com.ljaer.designpatterns.factory.Car;

public class BenzFactory extends AbstractFactory {

	@Override
	public Car getCar() {
		return new Benz();
	}

}
