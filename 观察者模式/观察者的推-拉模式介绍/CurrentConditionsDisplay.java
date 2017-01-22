package com.designPattern.observer;

import java.util.Map;

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
	
	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}

	@Override
	public void update(Subject subject, Map<String, Object> map) {
		// 这里为了简单起见，Observer一端维护Subject列表直接用if...else...代替了
		// 需要修改的话，维护Map<Subject, Map<String,Object> >，Observer作为一的一端，Subject作为多的一端
		// 下面的方法就可以改为subjectMap.replace(subject, map);
		if(subject instanceof WeatherData){
			this.temperature = (float) map.get("temperature");
			this.humidity    = (float) map.get("humidity");
			display();
		}
		// else if(subject instanceof ...)
	}
	
	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature 
				+ "F degrees and " + humidity + "% humidity");
	}

	
}
