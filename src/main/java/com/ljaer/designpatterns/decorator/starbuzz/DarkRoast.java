package com.ljaer.designpatterns.decorator.starbuzz;

/**
 * 烘焙
 */
public class DarkRoast extends Beverage {
	public DarkRoast() {
		description = "Dark Roast Coffee";
	}
 
	public double cost() {
		return .99;
	}
}

