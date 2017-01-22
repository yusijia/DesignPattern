package com.designPattern.observer;

import java.util.Map;

/**
 * 设计原则：
 * 	 为交互对象之间的松耦合度而努力
 * 
 * 观察者模式( 订阅者 + 发布者 )：
 *   当交互对象之间存在一对多的依赖，一的一方状态一旦发生改变，多的一方即会收到通知，进行状态的更新
 *   对应的即是：
 *     主题(1)与观察者(n) 
 *   主题的作用是 注册、移除、通知观察者
 *   观察者的作用是接收到特定主题的通知，进行状态或者数据的更新  
 *   
 *   根据数据在主题与观察者之间的传递方向，又可分为
 *   推(push)--当发布者的状态发生变化时，将数据推送给观察者(订阅者)。发布者维护一个观察者列表
 *   拉(pull)--当发布者的状态发生变化时，告知给观察者，由观察者自己来决定取什么数据。观察者维护一个发布者列表
 * 
 * 
 * @author ysj
 * 
 */
public interface Subject { // 发布者

	/**
	 * 注册观察者
	 * @param observer
	 */
	public void registerObserver(Observer obj);
	
	/**
	 * 移除观察者
	 * @param observer
	 */
	public void removeObserver(Observer obj);
	
	/**
	 * 通知观察者  拉的方式
	 */
	public void notifyObservers();
	
	/**
	 * 通知观察者  推的方式
	 */
	public void notifyObservers(Map<String, Object> map);
}
