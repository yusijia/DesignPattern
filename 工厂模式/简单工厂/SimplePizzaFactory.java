package com.designPattern.simpleFactory;

/**
 * 简单工厂：在一个类中处理创建对象的细节
 * 
 * 一个简单的工厂，用来生产pizza
 * @author ysj
 *
 */
public class SimplePizzaFactory {
	
	/**
	 * 根据不同类型生产不同的pizza
	 * @param type
	 * @return
	 */
	public Pizza createPizza(String type){
		Pizza pizza = null;
		
		if (type.equals("cheese")) {
			pizza = new CheesePizza();
		} else if (type.equals("pepperoni")) {
			pizza = new PepperoniPizza();
		} else if (type.equals("clam")) {
			pizza = new ClamPizza();
		} else if (type.equals("veggie")) {
			pizza = new VeggiePizza();
		}
		return pizza;
	}
	
}
