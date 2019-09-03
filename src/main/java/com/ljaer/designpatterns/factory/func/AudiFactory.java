package com.ljaer.designpatterns.factory.func;


import com.ljaer.designpatterns.factory.Audi;
import com.ljaer.designpatterns.factory.Car;

public class AudiFactory implements Factory {

	@Override
	public Car getCar() {
		return new Audi();
	}

}
