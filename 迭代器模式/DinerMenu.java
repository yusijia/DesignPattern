package com.designPattern.iterator;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 使用MenuItem[](数组)存放菜单项
 * @author ysj
 *
 */
public class DinerMenu<E> implements Menu<E>{

	private static final int size = 6;
	private int numberOfItems; // java默认初始化基本类型int为0
	
	private MenuItem[] menuItems;
  
	
	public DinerMenu() {
		menuItems = new MenuItem[size];
 
		addItem("Vegetarian BLT",
			"(Fakin') Bacon with lettuce & tomato on whole wheat", 2.99);
		addItem("BLT",
			"Bacon with lettuce & tomato on whole wheat", 2.99);
		addItem("Soup of the day",
			"Soup of the day, with a side of potato salad", 3.29);
		addItem("Hotdog",
			"A hot dog, with saurkraut, relish, onions, topped with cheese", 3.05);
		addItem("Steamed Veggies and Brown Rice",
			"Steamed vegetables over brown rice", 3.99);
		addItem("Pasta",
			"Spaghetti with Marinara Sauce, and a slice of sourdough bread",
			 3.89);
	}
	
	public void addItem(String name, String description, double price) 
	{
		MenuItem menuItem = new MenuItem(name, description, price);
		if (numberOfItems >= size) {
			System.err.println("Sorry, menu is full!  Can't add item to menu");
		} else {
			menuItems[numberOfItems] = menuItem;
			numberOfItems = numberOfItems + 1;
		}
	}
	
	public MenuItem[] getMenuItems() {
		return menuItems;
	}
	
	// 另外实现的一个返回值不为空的remove方法
	public MenuItem remove(int position){
		MenuItem item = menuItems[position];
		for (int i = position; i < (menuItems.length-1); i++) {
			menuItems[i] = menuItems[i+1];
		}
		menuItems[menuItems.length-1] = null;
		return item;
	}

	/**
	 * 自带一个默认的iterator
	 */
	@Override
	public Iterator<E> iterator() {
		return new Itr();
	}

	
	private class Itr implements Iterator<E>{

		int cursor;       // index of next element to return
		int lastRet = -1; // index of last element returned; -1 if no such
		
		@Override
		public boolean hasNext() {
			return cursor != size && DinerMenu.this.menuItems[cursor] != null;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			// ArrayList源码里的Itr中还有句checkForComodification();是用来检查在用迭代器遍历列表
			// 时，是否在外面有操作改变列表中的元素
			int i = cursor;
			if (i >= size)
                throw new NoSuchElementException();
			Object[] elementData = DinerMenu.this.menuItems;
			if(i >= elementData.length){
				throw new ConcurrentModificationException();
			}
			cursor = i + 1;
			return (E) elementData[lastRet = i];
		}
		
		public void remove() {
			if (lastRet < 0)
                throw new IllegalStateException();
			try{
				Object[] elementData = DinerMenu.this.menuItems;
				if (elementData[cursor-1] != null) {
					for (int i = cursor-1; i < (elementData.length-1); i++) {
						elementData[i] = elementData[i+1];
					}
					elementData[elementData.length-1] = null;
				}
			} catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
		}
		
	}
	
	
}
