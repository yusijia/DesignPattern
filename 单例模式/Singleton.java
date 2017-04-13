package com.designPattern.singleton;

/**
 * 单例模式：
 *   确保类只有一个实例，并提供一个全局的访问点
 *   
 *   经典的单例模式
 * 1、将构造器私有化
 * 2、提供一个私有的类的对象的静态成员变量(private static)
 * 3、提供一个静态的公有的获取对象的方法(getInstance())
 * 4、提供公有的、静态的、final的 类的单例属性(public static final), 在类加载时就实例化
 * 
 * 经典单例模式中 存在一个问题 当在多线程的环境中 可能会有多个ClassicSingleton的对象
 * 当然 可以在getInstance上加上synchronized 同步锁 但是每一次getInstance()的时候
 * 都需要同步 这样会极大地降低性能
 * 所以 查看另外两种变化体
 * 1、急切加载--在构建静态的实例变量时即初始化(不好之处在于，如果此类不使用的话，就浪费资源了)
 * 2、采用双重检查加锁的单例模式 既能够保证延迟实例化对象 又能不影响性能 此种方式最好
 * 
 * 
 * 最后注意一下：不同的类加载器加载同一个类，会产生多个单件并存的现象，所以，如果有多个类加载器，应该自行指定
 * 类加载器，并指定同一个类加载器
 * @author ysj
 * 下面是延迟实例化并线程安全版本的单例模式实现
 */
public class Singleton {

	// volatile关键字保证：当uniqueInstance遍历被初始化成Singleton实例时，多个线程正确地处理uniqueInstance变量
	// 保证多个线程操作uniqueInstance变量的原子性
	private volatile static Singleton uniqueInstance;

	private Singleton() {}
	
	/**
	 * 双重检查实现单例模式
	 * @return
	 */
	public static Singleton getInstance(){
		if(uniqueInstance == null){
			// 第一次实例化的时候才需要加锁
			synchronized (Singleton.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Singleton();
				}
			}
		}
		return uniqueInstance;
	}
}
