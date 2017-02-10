package com.designPattern.proxy;

/**
 * 代理模式：给真实对象提供一个替身，以控制对这个对象的访问
 * 
 * Person接口 
 * 	  代理和被代理的共同接口: 这允许任何客户都可以像处理RealSubject对象一样处理proxy对象
 * @author ysj
 *
 */
public interface PersonBean {

	String getName();
	String getGender();
	String getInterests();
	int getHotOrNotRating();
 
    void setName(String name);
    void setGender(String gender);
    void setInterests(String interests);
    void setHotOrNotRating(int rating); 
 
	
}
