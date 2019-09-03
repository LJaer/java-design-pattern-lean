package com.ljaer.designpatterns.decorator.starbuzz;

/**
 * 抽象调料装饰者
 */
public abstract class CondimentDecorator extends Beverage {
	Beverage beverage;
	public abstract String getDescription();
}
