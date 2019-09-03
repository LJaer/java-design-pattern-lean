package com.ljaer.designpatterns.decorator.starbuzz;

/**
 * 混合咖啡
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    public double cost() {
        return .89;
    }
}

