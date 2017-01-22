package com.designPattern.abstractFactory;

/**
 * 简单工厂模式
 * @author ysj
 *
 */
public class VeggiePizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
 
	public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
 
	@Override
	public void prepare() {
		String name = this.getName();
		Dough dough = this.getDough();
		Sauce sauce = this.getSauce();
		Cheese cheese = this.getCheese();
		
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
	}
}
