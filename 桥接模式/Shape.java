package com.designPattern.bridge;

public abstract class Shape {

	/**
	 * 使用 DrawAPI 接口创建抽象类 Shape
	 */
	protected DrawAPI drawAPI;
	
	public Shape(DrawAPI drawAPI) {
		this.drawAPI = drawAPI;
	}
	
	public abstract void draw();
}
