package com.designPattern.abstractFactory;

/**
 * 提供纽约风格Pizza原材料的工厂
 * @author ysj
 *
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory{

	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
	
}
