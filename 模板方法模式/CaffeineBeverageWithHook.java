package com.designPattern.templateMethod;

/**
 * 含咖啡因的饮料抽象类
 * 
 * 模板方法模式： 
 * 		定义了一个算法的框架，允许继承的子类为其提供一个或多个步骤的实现方法或可选的实现方法(hook)
 * 
 * 注意： 模板方法模式的重点是提供一个算法，并让继承的子类实现某些步骤。但也有类似的变体，
 *  例如：在java里数组是不能被继承的，但又想将sort方法运用于所有数组，于是在Arrays数组工具类中定义了
 *  一个静态的sort方法，基本类型的数组可直接排序，而自定义类数组排序需要自定义类继承Comparable接口
 *  并实现 ComareTo方法
 * 
 * 
 * 
 *   模板方法和策略方法都封装算法，模板使用继承，策略使用组合
 *   
 * 钩子（Hook）：
 *   被声明在抽象类中的方法，但是有默认的或者空的实现，给子类决定要不要重写
 *   让子类决定算法中的某些部分是否需要
 * 
 * 示例： 咖啡和茶的冲泡过程 
 * 咖啡：把水煮开、用沸水冲泡咖啡、把咖啡倒进杯子、加糖和牛奶 
 * 茶叶：把水煮开、用沸水浸泡茶叶、把茶倒进杯子、加柠檬
 *   
 * @author ysj
 *
 */
public abstract class CaffeineBeverageWithHook {

	/**
	 * 定义基本算法
	 * 茶和咖啡的冲泡算法 模板方法声明为final 不允许子类重写
	 */
	public void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		// 加上钩子 控制步骤
		if (customerWantsCondiments()) {
			addCondiments();
		}
	}
	
	/*
	 * 这个方法必须由子类决定实现细节
	 */
	public abstract void brew();
	
	/*
	 * 这个方法必须由子类决定实现细节
	 */
	public abstract void addCondiments();
 
	/**
	 * 默认实现方法
	 */
	public void boilWater() {
		System.out.println("Boiling water");
	}
 
	public void pourInCup() {
		System.out.println("Pouring into cup");
	}
 
	/**
	 * 钩子方法： 
	 *   子类可选的实现方法
	 * @return
	 */
	public boolean customerWantsCondiments() {
		return true;
	}
	
}
