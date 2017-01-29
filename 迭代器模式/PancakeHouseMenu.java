package com.designPattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 使用ArrayList存放菜单项
 * @author ysj
 *
 */
public class PancakeHouseMenu<E> implements Menu<E>{

	private ArrayList<E> menuItems;
	
	public PancakeHouseMenu() {
		menuItems = (ArrayList<E>) new ArrayList<E>();
    
		addItem("K&B's Pancake Breakfast", 
			"Pancakes with scrambled eggs, and toast", 2.99);
 
		addItem("Regular Pancake Breakfast", 
			"Pancakes with fried eggs, sausage", 2.99);
 
		addItem("Blueberry Pancakes",
			"Pancakes made with fresh blueberries, and blueberry syrup", 3.49);
 
		addItem("Waffles",
			"Waffles, with your choice of blueberries or strawberries", 3.59);
	}
	
	@SuppressWarnings("unchecked")
	public void addItem(String name, String description, double price)
	{
		MenuItem menuItem = new MenuItem(name, description, price);
		menuItems.add((E) menuItem);
	}
	
	public ArrayList<E> getMenuItems() {
		return (ArrayList<E>) menuItems;
	}
	
	@Override
	public Iterator<E> iterator() {
		return menuItems.iterator();
	}

	
	
}
