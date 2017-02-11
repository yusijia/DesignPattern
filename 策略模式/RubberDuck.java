package com.designPattern.strategy;

public class RubberDuck  extends Duck{

	public RubberDuck() {
		// 选择策略
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	}
	
	@Override
	public void display() {
		System.out.println("I'm a rubber duckie");
	}

}
