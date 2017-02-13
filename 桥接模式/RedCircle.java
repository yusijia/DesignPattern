package com.designPattern.bridge;

public class RedCircle implements DrawAPI{

	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println("Drawing RedCircle[ color: red, radius: "
		         + radius +", x: " +x+", "+ y +"]");
	}

}
