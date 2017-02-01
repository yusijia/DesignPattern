package com.designPattern.state;

/**
 * 如果方法里的重复代码占大部分，可以考虑改为抽象类，提供默认实现
 * 
 * 状态模式：
 *   允许对象在内部状态改变时改变他的行为，对象看起来好像修改了他的类
 *   
 *   封装基于状态的行为，并将行为委托到当前状态 
 *   通过把状态封装进一个类，把以后要做的事情局部化了
 *   
 *   策略模式和状态模式有相同的类图，但是彼此的意图不同
 *   
 *   示例
 *   糖果机模型
 *    5个状态：没有5块钱状态、有5块钱状态、赢家模式状态、出售糖果状态  、糖果售罄状态
 *    4个动作：投5块钱、退5块钱、按钮售出按钮、售出糖果
 *    
 * @author ysj
 *
 */
public interface State {

	/**
	 * 投入25分钱
	 */
	public void insertQuarter();
	
	/**
	 * 退钱
	 */
	public void ejectQuarter();
	
	/**
	 * 转动旋钮
	 */
	public void turnCrank();
	
	/**
	 * 发放商品
	 */
	public void dispense();
	
}
