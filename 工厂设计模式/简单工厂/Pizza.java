package com.designPattern.simpleFactory;

import java.util.ArrayList;

/**
 * 抽象披萨类
 * @author ysj
 *
 */
abstract  public class Pizza {
	String name;	// 名字
	// 基本原料
	String dough;	// 面团
	String sauce;	// 酱
	// 配料
	ArrayList toppings = new ArrayList();
	
	public String getName(){
		return name;
	}
	
	public String toString() {
		StringBuffer display = new StringBuffer();
		display.append("---- " + name + " ----\n");
		display.append(dough + "\n");
		display.append(sauce + "\n");
		for (int i = 0; i < toppings.size(); i++) {
			display.append((String )toppings.get(i) + "\n");
		}
		return display.toString();
	}
	
	public void prepare() {
		System.out.println("Preparing " + name);
	}

	public void bake() {
		System.out.println("Baking " + name);
	}

	public void cut() {
		System.out.println("Cutting " + name);
	}

	public void box() {
		System.out.println("Boxing " + name);
	}
	
}	
