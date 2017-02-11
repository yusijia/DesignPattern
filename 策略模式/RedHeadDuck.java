package com.designPattern.strategy;

public class RedHeadDuck extends Duck{

	public RedHeadDuck() {
		// 选择策略
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}
	
	@Override
	public void display() {
		System.out.println("I'm a real Red Headed duck");
	}

}
