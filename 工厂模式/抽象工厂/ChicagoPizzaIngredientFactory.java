package com.designPattern.abstractFactory;

/**
 * 提供芝加哥风格Pizza原材料的工厂
 * @author ysj
 *
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory{

	@Override
	public Dough createDough() {
		return new ThickCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	@Override
	public Cheese createCheese() {
		return new MozzarellaCheese();
	}
	
}
