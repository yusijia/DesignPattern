package com.designPattern.composite;

import java.util.Iterator;
import java.util.Stack;

/**
 * 自定义迭代器
 * 
 * 负责遍历组件内的所有MenuItem(菜单项)，以便于打印出素材的菜单
 * @author ysj
 *
 */
public class CompositeIterator implements Iterator{
	// 使用堆栈 迭代树形结构
	private Stack stack = new Stack();
	   
	public CompositeIterator(Iterator iterator) {
		stack.push(iterator);
	}
   
	@Override
	public Object next() {
		if (hasNext()) {
			Iterator iterator = (Iterator) stack.peek();
			MenuComponent component = (MenuComponent) iterator.next();
			// 如果是菜单的话 ,入栈 ,遍历 菜单中的菜单项
			if (component instanceof Menu) {
				stack.push(component.createIterator());
			} 
			return component;
		} else {
			return null;
		}
	}
  
	@Override
	public boolean hasNext() {
		if (stack.empty()) {
			return false;
		} else {
			Iterator iterator = (Iterator) stack.peek();
			if (!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}
   
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
}
