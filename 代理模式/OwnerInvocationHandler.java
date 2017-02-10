package com.designPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 评价自己的处理器
 * 
 * 1.可以查看自己的相关信息
 * 2.无法评价自己
 * 3.可以自己修改自己的其他项
 * 
 * @author ysj
 *
 */
public class OwnerInvocationHandler implements InvocationHandler{
	
	private PersonBean person;
	 
	public OwnerInvocationHandler(PersonBean person) {
		this.person = person;
	}
	
	// 控制访问
	// 下面是一种叫保护代理的用法，对访问做了一些限制
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
		try {
			if (method.getName().startsWith("get")) {// 可以查看相关信息
				return method.invoke(person, args);
   			} else if (method.getName().equals("setHotOrNotRating")) {// 无法评价自己
				throw new IllegalAccessException();
			} else if (method.getName().startsWith("set")) {// 可以自己修改自己的其他项
				return method.invoke(person, args);
			} 
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } 
		return null;
	}

}
