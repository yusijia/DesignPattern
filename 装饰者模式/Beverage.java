package com.designPattern.decorate;

/**
 * 设计原则： 开放-关闭原则： 对扩展开放，对修改关闭
 * 
 * 装饰模式： 动态的为对象添加附加功能,提供了一种扩展机制，比继承更具有扩展性
 * 
 * 涉及到的概念： 
 *    组合和委托可在运行时动态的加上新的行为
 * 装饰者中拥有被装饰者的超级父类，用于指向被装饰者，当对装饰者进行操作时，被装饰者即委托装饰者执行相关操作
 * 装饰者和被装饰者必须拥有相同的超级父类，用于装饰者替换被装饰者
 * 
 * @author ysj
 *
 */
public abstract class Beverage {
	
	/**
	 * 用于饮料的描述
	 */
	public String description = "Unknown Beverage";
	
	/**
	 * 用于计算不同饮料的价钱
	 * @return
	 */
	public abstract double cost();
	
	
	public String getDescription(){
		return description;
	}
	
}
