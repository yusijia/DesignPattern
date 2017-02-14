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
	 * 打印菜单中的素菜菜单项
	 */
	public void printVegetarianMenu() {
		Iterator iterator = allMenus.createIterator();

		System.out.println("\nVEGETARIAN MENU\n----");
		while (iterator.hasNext()) {
			MenuComponent menuComponent = 
					(MenuComponent)iterator.next();
			try {
				// 表示是菜单项，并且是素菜
				if (menuComponent.isVegetarian()) {
					menuComponent.print();
				}
			} catch (UnsupportedOperationException e) {}// 有的方法没加@Deprecated，默认是抛异常
		}
	}
}
