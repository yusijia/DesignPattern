package com.designPattern.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherData implements Subject{
	
	// 观察者可根据情况参考的参数
	private float temperature;
	private float humidity;
	private float pressure;
	
	/**
	 * 记录状态是否改变
	 */
	private boolean changed;
	
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
	public void registerObserver(Observer obj) {
		if(!observers.contains(obj)){
			observers.add(obj);
		}
	}

	/**
	 * 移除观察者
	 * @param observer
	 */
	@Override
	public void removeObserver(Observer obj) {
		/*
			int i = observers.indexOf(obj);
			if (i >= 0) {
				observers.remove(i);
			}
		*/
		if(observers.contains(obj)){
			observers.remove(obj);
		}
	}

	/**
	 * 通知观察者  拉的方式
	 */
	@Override
	public void notifyObservers() {
		// 如果发布者的数据改变了
		if(isChanged()){
			for(Observer observer : observers){
				observer.update(temperature, humidity, pressure);// 强行把观察者拉过来并执行updata方法
			}
		}
		setChanged(false);
	}
	
	/**
	 * 通知观察者  以推的方式
	 */
	@Override
	public void notifyObservers(Map<String, Object> map){
		// 如果发布者的数据改变了
		if(isChanged()){
			for(Observer observer : observers){
				observer.update(this, map);// 将自己的数据打包并将自己推送出去。观察者维护一个发布者的列表。
			}
		}
		setChanged(false);
	}
	
	/**
	 * 改变发布者的状态，并通知观察者  以拉的方式
	 * @param temperature
	 * @param humidity
	 * @param pressure
	 */
	public void setMeasurementsAndPull(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		// 发布者的状态改变了，这里采用拉的方式告知订阅者
		setChanged(true);
		notifyObservers();
	}
	
	/**
	 *  改变发布者的状态，并通知观察者  以推的方式
	 * @param temperature
	 * @param humidity
	 * @param pressure
	 */
	public void setMeasurementsAndPush(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("temperature", temperature);
		map.put("humidity", humidity);
		map.put("pressure", pressure);
		setChanged(true);
		notifyObservers(map);
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
	
	public boolean isChanged(){
		return changed;
	}
	
	public void setChanged(boolean changed){
		this.changed = changed;
	}
}
