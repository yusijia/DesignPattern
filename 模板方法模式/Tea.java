package com.designPattern.templateMethod;

public class Tea extends CaffeineBeverageWithHook{

	@Override
	public void brew() {
		System.out.println("Steeping the tea");
	}

	@Override
	public void addCondiments() {
		System.out.println("Adding Lemon");
	}

}
