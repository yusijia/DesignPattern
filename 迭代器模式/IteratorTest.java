package com.designPattern.iterator;

public class IteratorTest {
	
	public static void main(String[] args) {
		// 创建两个菜单
		PancakeHouseMenu<MenuItem> pancakeHouseMenu = new PancakeHouseMenu<MenuItem>();
		DinerMenu<MenuItem> dinerMenu = new DinerMenu<MenuItem>();
		
		// 服务员接收到两个菜单，并处理打印出来
		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
		waitress.printMenu();
		
	}
	
}
