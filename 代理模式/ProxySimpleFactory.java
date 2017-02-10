package com.designPattern.proxy;

import java.lang.reflect.Proxy;

/**
 * 使用简单工厂
 * 	  利用JDK内置的代理创建personBean的相应的代理对象
 * @author ysj
 *
 */
public class ProxySimpleFactory{

	// 返回自己评价自己的代理对象，该代理对象的所有方法都要通过相应的handler的invoke方法访问
	public static PersonBean getOwnerPersonBean(PersonBean personBean){
		return (PersonBean) Proxy.newProxyInstance(
				personBean.getClass().getClassLoader(),// PersonBean的类加载器
				personBean.getClass().getInterfaces(), // PersonBean实现的接口
				new OwnerInvocationHandler(personBean));// 相对应的处理器
	}
	
	// 返回评价别人的代理对象
	public static PersonBean getNonOwnerPersonBean(PersonBean personBean){
		return (PersonBean) Proxy.newProxyInstance(
				personBean.getClass().getClassLoader(), 
				personBean.getClass().getInterfaces(), 
				new NonOwnerInvocationHandler(personBean));
	}
	
}
