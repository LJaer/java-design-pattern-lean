package com.ljaer.designpatterns.decorator.starbuzz;

/**
 * 脱咖啡因咖啡
 */
public class Decaf extends Beverage {
    public Decaf() {
        description = "Decaf Coffee";
    }

    public double cost() {
        return 1.05;
    }
}