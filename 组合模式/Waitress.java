package com.designPattern.composite;

import java.util.Iterator;

public class Waitress {
	private MenuComponent allMenus;
	
	public Waitress(MenuComponent allMenus) {
		this.allMenus = allMenus;
	}
 
	/**
	 * 打印所有菜单
	 */
	public void printMenu() {
		allMenus.print();
	}
	
	/**
	 * 打印所有素食的菜单
	 */
	public void printVegetarianMenu() {
		Iterator iterator = allMenus.createIterator();

		System.out.println("\nVEGETARIAN MENU\n----");
		while (iterator.hasNext()) {
			MenuComponent menuComponent = 
					(MenuComponent)iterator.next();
			try {
				if (menuComponent.isVegetarian()) {
					menuComponent.print();
				}
			} catch (UnsupportedOperationException e) {}
		}
	}
}
