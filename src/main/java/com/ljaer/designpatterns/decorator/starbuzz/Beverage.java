package com.ljaer.designpatterns.decorator.starbuzz;

/**
 * 饮料
 */
public abstract class Beverage {
	String description = "Unknown Beverage";
  
	public String getDescription() {
		return description;
	}
 
	public abstract double cost();
}
