package com.designPattern.abstractFactory;

/**
 * 抽象工厂：
 *    定义了一个接口，提供了创建依赖对象的家族，但是不指定具体创建什么类型  
 *  抽象工厂使用组合概念，构建对象的家族 
 * @author ysj
 *
 */
public interface PizzaIngredientFactory {
 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
 
}
