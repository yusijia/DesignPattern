package com.designPattern.observer;

/**
 * 布告板二
 * @author ysj
 *
 */
public class ForecastDisplay implements Observer, DisplayElement{
	
	// 与该布告板相关的参数
	private float currentPressure = 29.92f;  
	private float lastPressure;
	// 关联发布者
	private Subject weatherData;

	public ForecastDisplay(WeatherData weatherData){
		// 关联发布者
		this.weatherData = weatherData;
		// 注册观察者(订阅者)
		weatherData.registerObserver(this); // 将其加入观察者列表
	}
	
	@Override
	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		lastPressure = currentPressure;
		currentPressure = pressure;

		display();
	}

}
