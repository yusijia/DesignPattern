package com.designPattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 服务员
 * @author ysj
 *
 */
public class Waitress {
	
	// 将菜单都放在ArrayList里
	private ArrayList<Menu<MenuItem> > list;
	
 
	public Waitress(Menu<MenuItem> pancakeHouseMenu, Menu<MenuItem> dinerMenu) {
		list.add(pancakeHouseMenu);
		list.add(dinerMenu);
	}
 
	public void printMenu() {		
		Iterator<Menu<MenuItem> > menuIterator = list.iterator();
		while(menuIterator.hasNext()){
			Menu<MenuItem> menu = (Menu<MenuItem>)menuIterator.next();
			printMenu(menu.iterator());
		}
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
