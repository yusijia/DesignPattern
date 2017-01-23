package com.designPattern.adapter;

import java.util.Random;

/**
 * 鸭子适配器
 * 
 * 
 * 适配器模式
 *     将一种接口转换为用户所期望的另一种接口
 * 
 * 对象适配器--使用组合拥有被适配者接口，使用实现实现目的接口
 * 类适配器--使用继承拥有被适配者与目的类(java不支持多重继承)
 * 
 * 目的接口：用户所期望的接口
 * 被适配器接口：待转换的接口
 * 
 * 适配器：实现目的接口，同时使用组合包含被适配器接口，将被适配器接口转换为目的接口
 * 适配器让原本接口不兼容的类可以合作无间
 * 
 * 实例
 *   火鸡与鸭子
 *     鸭子会叫，也会飞
 *     火鸡只会咯咯叫 飞的很近
 *     将火鸡转换为鸭子
 * 
 * @author ysj
 *
 */
public class DuckAdapter implements Turkey{

	// 组合Duck
	private Duck duck;
	private Random rand;
	
	
	public DuckAdapter(Duck duck) {
		this.duck = duck;
		rand = new Random();
	}
	
	// 火鸡的行为
	
	@Override
	public void gobble() {
		duck.quack();
	}

	@Override
	public void fly() {
		duck.fly();
	}

	
	
}
