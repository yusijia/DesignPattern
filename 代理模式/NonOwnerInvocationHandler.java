package com.designPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 评价其他人的处理器
 * 
 * 1.可以查看其他人的相关信息
 * 2.可以设置其他人的评分
 * 3.不能修改其他人的其他项
 * 
 * @author ysj
 *
 */
public class NonOwnerInvocationHandler implements InvocationHandler{
	private PersonBean person;
	
	public NonOwnerInvocationHandler(PersonBean person) {
		this.person = person;
	}

	// 控制访问
	// 下面是一种叫保护代理的用法，对访问做了一些限制
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
		try {
			if (method.getName().startsWith("get")) {// 可以查看相关信息
				return method.invoke(person, args);
   			} else if (method.getName().equals("setHotOrNotRating")) {// 可以设置其他人的评分
				return method.invoke(person, args);
			} else if (method.getName().startsWith("set")) {// 不能修改其他人的其他项
				throw new IllegalAccessException();
			} 
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } 
		return null;
	}
}
