package com.designPattern.factoryMethod;


abstract public class PizzaStore {

	/**
	 * 工厂方法：
	 * 	       让子类决定初始化什么样的对象，即将类的实例化推迟到子类中进行
	 * 工厂方法使用继承，将对象的创建委托给子类进行创建  
	 * 
	 * 工厂对象移回该方法中(对比简单工厂)
	 * //简单工厂方式让我们还是依赖 于一个特定的实现  我们需要依赖于抽象
	 * //Pizza pizza = PizzaSimpleFactory.createPizza(type);
	 * 
	 * 依赖倒置原则：依赖于抽象，而非具体实现
	 * 
	 * @param item
	 * @return
	 */
	protected abstract Pizza createPizza(String item);
	
	public Pizza orderPizza(String type) {
		
		Pizza pizza = createPizza(type);
		//保证制作披萨的流程一致
		System.out.println("--- Making a " + pizza.getName() + " ---");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
	
}
