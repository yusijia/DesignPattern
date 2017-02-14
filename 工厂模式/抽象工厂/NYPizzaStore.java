package com.designPattern.abstractFactory;

public class NYPizzaStore extends PizzaStore {
	
	private PizzaIngredientFactory ingredientFactory;

	@Override
	protected Pizza createPizza(String type) {
		Pizza pizza = null;
		// 使用组合构建对象家族
		ingredientFactory = 
			new NYPizzaIngredientFactory();
 
		if (type.equals("cheese")) {
  
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");
		}
		return pizza;
	}
}
