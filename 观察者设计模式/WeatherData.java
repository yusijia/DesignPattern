package com.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{
	
	// 观察者可根据情况参考的参数
	private float temperature;
	private float humidity;
	private float pressure;
	
	// 观察者列表
	private List<Observer> observers;

	public WeatherData() {
		observers = new ArrayList<Observer>();
	}
	
	/**
	 * 注册观察者
	 * @param observer
	 */
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	/**
	 * 移除观察者
	 * @param observer
	 */
	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	/**
	 * 通知观察者  拉的方式
	 */
	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}

	/**
	 * 若属性有变化则调用这个方法通知观察者
	 */
	public void measurementsChanged() {
		notifyObservers();
	}
	
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		// 属性改变了，通知观察者
		measurementsChanged();
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}
}
