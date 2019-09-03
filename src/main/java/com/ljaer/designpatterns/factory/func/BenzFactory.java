package com.ljaer.designpatterns.factory.func;

import com.ljaer.designpatterns.factory.Benz;
import com.ljaer.designpatterns.factory.Car;

public class BenzFactory implements Factory {

    @Override
    public Car getCar() {
        return new Benz();
    }

}
