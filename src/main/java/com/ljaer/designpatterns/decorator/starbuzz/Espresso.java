package com.ljaer.designpatterns.decorator.starbuzz;

/**
 * 浓咖啡
 */
public class Espresso extends Beverage {
  
	public Espresso() {
		description = "Espresso";
	}
  
	public double cost() {
		return 1.99;
	}
}