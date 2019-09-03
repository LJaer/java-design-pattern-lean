package com.ljaer.designpatterns.factory.abstr;

import com.ljaer.designpatterns.factory.Car;

public class DefaultFactory extends AbstractFactory {

	private AudiFactory defaultFactory = new AudiFactory();

	public Car getCar() {
		return defaultFactory.getCar();
	}

}
