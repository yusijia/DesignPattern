package com.designPattern.iterator;

import java.util.Iterator;


public interface Menu<E> {

	/**
	 * 获取菜单自带的默认迭代器
	 * @return
	 */
	public Iterator<E> iterator();
	
}
