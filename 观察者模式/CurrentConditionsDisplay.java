package com.designPattern.observer;

/**
 * 布告板一
 * @author ysj
 *
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement{

	// 与该布告板相关的参数
	private float temperature;
	private float humidity;
	// 关联发布者
	private Subject weatherData;
	
	
	public CurrentConditionsDisplay(Subject weatherData) {
		// 关联发布者
		this.weatherData = weatherData;
		// 注册观察者(订阅者)
		weatherData.registerObserver(this);// 将其加入观察者列表
	}
	
	/**
	 * 更新数据
	 */
	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}

	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature 
				+ "F degrees and " + humidity + "% humidity");
	}

	
}
