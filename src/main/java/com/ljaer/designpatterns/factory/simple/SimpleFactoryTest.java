package com.ljaer.designpatterns.factory.simple;


import com.ljaer.designpatterns.factory.Car;

public class SimpleFactoryTest {

	public static void main(String[] args) {
		//这边就是我们的消费者
		Car car = new SimpleFactory().getCar("audi");
		System.out.println(car.getName());
	}

}
