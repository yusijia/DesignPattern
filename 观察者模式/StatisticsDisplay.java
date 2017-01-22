package com.designPattern.observer;


/**
 * 布告板三
 * @author ysj
 *
 */
public class StatisticsDisplay implements Observer, DisplayElement{

	// 与该布告板相关的参数
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum = 0.0f;
	private int numReadings;
	// 关联发布者
	private Subject weatherData;
	
	
	public StatisticsDisplay(WeatherData weatherData){
		// 关联发布者
		this.weatherData = weatherData;
		// 注册观察者(订阅者)
		weatherData.registerObserver(this); // 将其加入观察者列表
	}
	
	@Override
	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
				+ "/" + maxTemp + "/" + minTemp);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		// 自定义的展示前的数据处理
		tempSum += temp;
		numReadings++;

		if (temp > maxTemp) {
			maxTemp = temp;
		}
 
		if (temp < minTemp) {
			minTemp = temp;
		}
		// 展示
		display();
	}

}
