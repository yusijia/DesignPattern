package com.designPattern.observer;

import java.util.Map;

/**
 * 观察者(订阅者)
 * @author ysj
 *
 */
public interface Observer {
	
	/**
	 * 获取发布者的更新数据，及时更新自己的状态
	 * @param temp
	 * @param humidity
	 * @param pressure
	 */
	public void update(float temp, float humidity, float pressure);
	
	/**
	 * 获取发布者的更新数据，及时更新自己的状态
	 * @param subject
	 * @param map
	 */
	public void update(Subject subject, Map<String, Object> map);
	
}
