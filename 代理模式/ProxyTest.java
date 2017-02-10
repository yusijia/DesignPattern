package com.designPattern.proxy;

import java.util.HashMap;

public class ProxyTest {

	// 模拟数据库
	HashMap<String, Object> datingDB = new HashMap<String, Object>();
	
	// 初始化一下
	public ProxyTest() {
		initializeDatabase();
	}
	
	public static void main(String[] args) {
		ProxyTest test = new ProxyTest();
		test.drive();
	}
	
	public void drive() {
		// 测试自己评价自己
		PersonBean joe = getPersonFromDatabase("Joe Javabean"); 
		// 用简单工厂创建相应的代理对象
		PersonBean ownerProxy = ProxySimpleFactory.getOwnerPersonBean(joe);
		// 代理对象去访问真实对象的方法
		System.out.println("Name is " + ownerProxy.getName());
		ownerProxy.setInterests("bowling, Go");
		System.out.println("Interests set from owner proxy");
		try {
			// 这里尝试自己评价自己，但由于对应使用的是OwnerInvocationHandler处理器，所以会报异常
			ownerProxy.setHotOrNotRating(10);
		} catch (Exception e) {
			System.out.println("Can't set rating from owner proxy");
		}
		// 代理对象去访问真实对象的方法
		System.out.println("Rating is " + ownerProxy.getHotOrNotRating());

		// 测试评价其他人
		// 用简单工厂创建相应的代理对象
		PersonBean nonOwnerProxy = ProxySimpleFactory.getNonOwnerPersonBean(joe);
		// 代理对象去访问真实对象的方法
		System.out.println("Name is " + nonOwnerProxy.getName());
		try {
			// 这里尝试设置其他人的私人项
			nonOwnerProxy.setInterests("bowling, Go");
		} catch (Exception e) {
			// 由于评价其他人时不准修改私人项，用的是NonOwnerInvocationHandler处理器。所以会报错
			System.out.println("Can't set interests from non owner proxy");
		}
		// 评价其他人
		nonOwnerProxy.setHotOrNotRating(3);
		System.out.println("Rating set from non owner proxy");
		// 代理对象去访问真实对象的方法
		System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());
	}
	
	// 模拟向数据库存了两个人
	private void initializeDatabase() {
		PersonBean joe = new PersonBeanImpl();
		joe.setName("Joe Javabean");// 人名
		joe.setInterests("cars, computers, music");
		joe.setHotOrNotRating(7);
		datingDB.put(joe.getName(), joe);

		PersonBean kelly = new PersonBeanImpl();
		kelly.setName("Kelly Klosure");// 人名
		kelly.setInterests("ebay, movies, music");
		kelly.setHotOrNotRating(6);
		datingDB.put(kelly.getName(), kelly);
	}
	
	// 模拟从数据库中取出对应名字的PersonBean对象
	private PersonBean getPersonFromDatabase(String name) {
		return (PersonBean)datingDB.get(name);
	}
	
}
