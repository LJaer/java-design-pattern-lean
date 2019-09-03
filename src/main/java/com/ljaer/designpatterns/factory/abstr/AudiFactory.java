package com.ljaer.designpatterns.factory.abstr;


import com.ljaer.designpatterns.factory.Audi;
import com.ljaer.designpatterns.factory.Car;

//具体的业务逻辑封装
public class AudiFactory extends AbstractFactory {

	@Override
	public Car getCar() {
		return new Audi();
	}

}
