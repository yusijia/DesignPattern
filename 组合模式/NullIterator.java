package com.designPattern.composite;

import java.util.Iterator;

/**
 * 空迭代器
 * @author ysj
 *
 * @param <E>
 */
public class NullIterator<E> implements Iterator<E>{

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public E next() {
		return null;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	
}
