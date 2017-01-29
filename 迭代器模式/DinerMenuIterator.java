package com.designPattern.iterator;

import java.util.Iterator;

/**
 * 数组菜单的自定义迭代器
 * 
 * 设计原则：
 *   单一原则：一个类应该只有一个引起变化的原因
 *   内聚--用来衡量一个类或者模块紧密的达到单一目的或责任
 *   高内聚--表示一个类或者模块只支持一个/一组相关功能
 * 
 * 迭代器模式：
 *   提供一种顺序访问聚合对象元素的方法，而又不暴露其内部元素
 * 迭代器将遍历聚合对象的任务封装到一个对象(可以是聚合对象中也可以是自定义的迭代器对象)中。
 * 
 * 示例：
 *   早餐、午餐
 * 通过菜单接口 提供给客户统一的访问菜单项的方式 而不用知道菜单项的管理方式
 * 
 * @author ysj
 *
 */
public class DinerMenuIterator<E> implements Iterator<E>{

	private MenuItem[] items;
	private int position;
	
	public DinerMenuIterator(Menu<E> dinerMenu) {
		this.items = ((DinerMenu<E>)dinerMenu).getMenuItems();
		position = 0;
	}
	
	@Override
	public boolean hasNext() {
		if (position >= items.length || items[position] == null) {
			return false;
		} else {
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		MenuItem menuItem = items[position];
		position = position + 1;
		return (E) menuItem;
	}

	public void remove() {
		/*throw new UnsupportedOperationException(
			"Alternating Diner Menu Iterator does not support remove()");*/
		// 注意这个迭代器里的remove方法的特殊要求,如果数组中只有一个元素则不能删除
		if (position <= 0) {
			throw new IllegalStateException
				("You can't remove an item until you've done at least one next()");
		}
		if (items[position-1] != null) {
			for (int i = position-1; i < (items.length-1); i++) {
				items[i] = items[i+1];
			}
			items[items.length-1] = null;
		}
	}
	
}
