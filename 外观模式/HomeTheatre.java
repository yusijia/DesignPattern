package com.designPattern.facade;

/**
 * 设计原则：
 *   最少知识原则：只和你的密友交谈
 * 为了只和你的密友交谈，对象中方法应该只出现在一下四种情况调用
 *   1、对象本身中
 *   2、对象作为其他对象的任何组件
 *   3、对象作为方法参数进行传递
 *   4、此方法所创建的实例化对象中
 *   1、3、4的意味着不要在调用其他方法返回的对象上调用其方法
 *     
 *  外观模式
 *   提供了一个统一的接口，用来访问子系统的一群接口
 *   定义了一个高层接口，让子系统更容易使用  
 * 外观模式只是提供了一个子系统的访问接口，并不影响子系统的单独使用
 * 外观模式强调统一和简化接口，而适配器模式强调转换接口
 * 
 * 示例
 *   家庭影院
 * @author ysj
 *
 */
public class HomeTheatre {

	// 组合的组件
	private Amplifier amp;
	private Projector pro;
	private Screen scr;
	private Curtain cur;
	
	public HomeTheatre(Amplifier amp,Projector pro,Screen scr,Curtain cur){
		this.amp = amp;
		this.pro = pro;
		this.cur = cur;
		this.scr = scr;
	}
	
	//简化的方法
	public void watchMovie(){
		cur.close();
		scr.down();
		pro.open();
		amp.openAmp();
		amp.setPlayer(0);
		amp.setVolume(10);
	}
	
	public void closeMovie(){
		amp.closeAmp();
		pro.close();
		scr.up();
		cur.open();
	}
	
}
