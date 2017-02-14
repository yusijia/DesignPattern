package com.designPattern.abstractFactory;

public class ChicagoPizzaStore extends PizzaStore {
	
	private PizzaIngredientFactory ingredientFactory;

	@Override
	protected Pizza createPizza(String type) {
		Pizza pizza = null;
		// 使用组合构建对象家族
		ingredientFactory =
		new ChicagoPizzaIngredientFactory();

		if (type.equals("cheese")) {
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Chicago Style Cheese Pizza");

		} 
		return pizza;
	}
}
