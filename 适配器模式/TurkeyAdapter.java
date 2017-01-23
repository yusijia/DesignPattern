package com.designPattern.adapter;

/**
 * 火鸡适配器
 * @author ysj
 *
 */
public class TurkeyAdapter implements Duck{

	// 组合Turkey
	private Turkey turkey;
	
	public TurkeyAdapter(Turkey turkey){
		this.turkey = turkey;
	}
	
	// 鸭子的行为
	
	@Override
	public void quack() {
		turkey.gobble();
	}

	@Override
	public void fly() {
		for(int i = 0; i < 5; i++) {
			turkey.fly();
		}
	}

	
	
}
