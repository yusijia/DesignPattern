package com.designPattern.iterator;

import java.util.Iterator;

/**
 * 服务员
 * @author ysj
 *
 */
public class Waitress {
	private Menu<MenuItem> pancakeHouseMenu;
	private Menu<MenuItem> dinerMenu;
 
	public Waitress(Menu<MenuItem> pancakeHouseMenu, Menu<MenuItem> dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}
 
	public void printMenu() {
		// 下面这两个是菜单类自带的迭代器
		Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.iterator();
		Iterator<MenuItem> dinerIterator = dinerMenu.iterator();
		// 下面这个迭代器是专门为DinerMenu菜单自定义的
		Iterator<MenuItem> userIterator = new DinerMenuIterator<MenuItem>(dinerMenu);
		

		System.out.println("MENU\n----\nBREAKFAST");
		printMenu(pancakeIterator);
		System.out.println("\nLUNCH");
		printMenu(dinerIterator);
		System.out.println("\nuserDefineIterator\n----\nLUNCH");
		printMenu(userIterator);
	}
 
	private void printMenu(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem)iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}
}
