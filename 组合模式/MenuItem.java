package com.designPattern.composite;

import java.util.Iterator;

/**
 * 叶节点
 * @author ysj
 *
 */
public class MenuItem extends MenuComponent{

	private String name;
	private String description;
	private boolean vegetarian;
	private double price;
	
	public MenuItem(String name, 
            String description, 
            boolean vegetarian, 
            double price) 
	{ 
		this.name = name;
		this.description = description;
		this.vegetarian = vegetarian;
		this.price = price;
	}
	
	@Override
	public Iterator createIterator() {
		return new NullIterator();
	}
	
	// 叶子节点的print方法
	@Override
	public void print() {
		System.out.print("  " + getName());
		if (isVegetarian()) {
			System.out.print("(v)");
		}
		System.out.println(", " + getPrice());
		System.out.println("     -- " + getDescription());
	}
	
	public String getName() {
		return name;
	}
  
	public String getDescription() {
		return description;
	}
  
	public double getPrice() {
		return price;
	}
  
	public boolean isVegetarian() {
		return vegetarian;
	}

	
	// 下面是不支持的MenuComponent组件里的方法
	@Deprecated
	public void add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	
	@Deprecated
	public MenuComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}
	
	@Deprecated
	public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	
	
}
