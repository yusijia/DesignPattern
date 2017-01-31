package com.designPattern.composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 组合节点
 * @author ysj
 *
 */
public class Menu extends MenuComponent{

	private ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
	private String name;
	private String description;
	
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	@Override
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}
	
	@Override
	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}
	
	@Override
	public MenuComponent getChild(int i) {
		return (MenuComponent)menuComponents.get(i);
	}
 
	
	@Override
	public Iterator createIterator() {
		return new CompositeIterator(menuComponents.iterator());
	}

	@Override
	public void print() {
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("---------------------");
  
		Iterator iterator = menuComponents.iterator();
		while (iterator.hasNext()) {
			MenuComponent menuComponent = (MenuComponent) iterator.next();
			// 调用叶子节点的print方法
			menuComponent.print();
		}
	}
	
	public String getName() {
		return name;
	}
 
	public String getDescription() {
		return description;
	}
	
	// 下面是不支持的MenuComponent组件里的方法
	@Deprecated
	public double getPrice() {
		throw new UnsupportedOperationException();
	}
	
	@Deprecated
	public boolean isVegetarian() {
		throw new UnsupportedOperationException();
	}
}
