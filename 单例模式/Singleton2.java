package com.ysj.simpleTest;

/**
 * 构造函数私有化
 * 私有的类的对象的静态成员设为static，并加载类的时候就实例化(急切加载)。(由于是私有的且没提过setter所有相当于final了)
 * 公有静态成员设为static final，并加载类的时候就实例化
 * @author yusijia
 * @Description:
 */
public class Singleton2 {

    private static Singleton2 ourInstance = new Singleton2();

    public static final String Attr = "某属性";

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return ourInstance;
    }

}
