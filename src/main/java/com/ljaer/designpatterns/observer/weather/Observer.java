package com.ljaer.designpatterns.observer.weather;

public interface Observer {
	/**
	 * @param temp 温度
	 * @param humidity 湿度
	 * @param pressure 气压
	 */
	public void update(float temp, float humidity, float pressure);
}
