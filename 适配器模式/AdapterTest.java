package com.designPattern.adapter;

public class AdapterTest {

	public static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
	
	public static void testTurkey(Turkey turkey) {
		turkey.gobble();
		turkey.fly();
	}
	
	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck();
		WildTurkey turkey = new WildTurkey();
		
		Duck turkey2Duck = new TurkeyAdapter(turkey);
		Turkey Duck2turkey = new DuckAdapter(duck);
		
		System.out.println("The Turkey says...");
		turkey.gobble();
		turkey.fly();
 
		System.out.println("\nThe Duck says...");
		testDuck(duck);
  
		System.out.println("\nThe turkey2Duck says...");
		testDuck(turkey2Duck);
		
		System.out.println("\nThe Duck2turkey says...");
		testTurkey(Duck2turkey);
	}
	
}
