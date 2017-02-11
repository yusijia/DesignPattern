package com.designPattern.strategy;

/**
 * 设计原则：
 * 1、针对接口编程，而非实现
 * 2、多用组合，少用继承
 * 3、封装变化
 * 
 * 策略模式：将算法簇封装起来，使使用算法的客体和算法之间相互独立
 * 
 * 示例：鸭子游戏
 * 
 * 每个鸭子都会游泳，都要显示自己的外观，但是每个鸭子还会有其他特定的行为，
 * 将变化的特定行为进行封装，抽象成接口，并提供变化行为的实现类，
 * 当每个鸭子有特定的行为时，只需实现特定的行为实现类即可，即可代码复用
 *  同时，每个鸭子可持有不同行为的接口，在运行时，可动态改变鸭子的行为，即是针对接口编程的好处
 *  当每个鸭子持有不同行为的接口作为成员变量时，鸭子和行为之间的耦合度减少了 ，
 *  当改变行为的操作时候，鸭子的原有代码都要不用变化，即算法簇变化，使用算法的客体不变，增强了软件的可维护性
 *  
 * 
 * @author ysj
 *
 */
public abstract class Duck {
	
	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;
	
	public Duck() { }
	
	// 设置行为策略
	public void setFlyBehavior (FlyBehavior fb) {
		flyBehavior = fb;
	}
 
	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
	
	/**
	 * 显示鸭子的外观，因为不同的鸭子的外观是不同的，留给子类自己实现
	 */
	public abstract void display();
	
	// 委托flyBehavior
	public void performFly() {
		flyBehavior.fly();
	}
 
	public void performQuack() {
		quackBehavior.quack();
	}
 
	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}
}
