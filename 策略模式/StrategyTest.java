package com.designPattern.strategy;

public class StrategyTest {

	public static void main(String[] args) {
		RedHeadDuck redHeadDuck = new RedHeadDuck();
		RubberDuck rubberDuck = new RubberDuck();
		
		System.out.println("redHeadDuck: ");
		redHeadDuck.performFly();
		redHeadDuck.performQuack();
		System.out.println("");
		
		System.out.println("rubberDuck: ");
		rubberDuck.performFly();
		rubberDuck.performQuack();
		System.out.println("");
		
		System.out.println("redHeadDuck with FlyNoWay of strategy: ");
		redHeadDuck.setFlyBehavior(new FlyNoWay());
		redHeadDuck.performFly();
		redHeadDuck.performQuack();
	}
	
	
}
