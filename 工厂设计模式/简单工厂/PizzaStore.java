package com.designPattern.simpleFactory;


public class PizzaStore {
	
	private SimplePizzaFactory factory;
	
	public PizzaStore(SimplePizzaFactory factory) { 
		this.factory = factory;
	}
	
	/**
	 * 订购pizza
	 * @param type
	 * @return
	 */
	public Pizza orderPizza(String type){
		Pizza pizza;
		// 使用简单工厂生产的pizza
		// 简单工厂方式让我们还是依赖 于一个特定的实现
		pizza = factory.createPizza(type);
		// 保证制作披萨的流程一致
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
	
}
