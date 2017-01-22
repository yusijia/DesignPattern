package com.designPattern.abstractFactory;

public abstract class PizzaStore {
 
	/**
	 * 工厂方法：
	 *     让子类决定初始化什么样的对象，即将类的实例化推迟到子类中进行
	 * 工厂方法使用继承，将对象的创建委托给子类进行创建  
	 * @param item
	 * @return
	 */
	protected abstract Pizza createPizza(String type);
 
	/**
	 * 订购Pizza
	 * @param type
	 * @return
	 */
	public Pizza orderPizza(String type) {
		
		Pizza pizza = createPizza(type);
		
		System.out.println("--- Making a " + pizza.getName() + " ---");
		// 保证流程统一
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
