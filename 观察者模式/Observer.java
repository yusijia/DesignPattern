package com.designPattern.observer;


/**
 * 观察者(订阅者)
 * @author ysj
 *
 */
public interface Observer {
	
	/**
	 * 获取发布者的更新数据
	 * @param temp
	 * @param humidity
	 * @param pressure
	 */
	public void update(float temp, float humidity, float pressure);
	
}
