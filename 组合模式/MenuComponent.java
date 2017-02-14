package com.designPattern.composite;

import java.util.Iterator;

/**
 * 
 * 
 * 组合模式以单一责任设计原则换区透明性——通过让组件的接口同时包含一些管理子节点和叶节点的操作，客户
 * 就可以将组合的叶节点一视同仁。
 * 
 *  组合(子节点)和叶节点都属于组件，只是两者的角色定位不同而已
 *  组合(子节点)--拥有一群子元素 
 *  叶节点--无子元素
 * 
 * @author ysj
 *
 */
public abstract class MenuComponent {

	public void add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	public MenuComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}
  
	public String getName() {
		throw new UnsupportedOperationException();
	}
	public String getDescription() {
		throw new UnsupportedOperationException();
	}
	public double getPrice() {
		throw new UnsupportedOperationException();
	}
	public boolean isVegetarian() {
		throw new UnsupportedOperationException();
	}

	public abstract Iterator createIterator();
 
	public void print() {
		throw new UnsupportedOperationException();
	}
	
}
