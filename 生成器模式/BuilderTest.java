package com.designPattern.builder;

import java.util.Scanner;

public class BuilderTest {

	public static void main(String[] args) {
		// 创建一个默认的旅游计划
		TravelBuilder builder1 = new VacationBuilder();
		Planner plan1 = builder1.getDefaultVacationPlanner();
		System.out.println(plan1);
		
		// 创建一个用户自定义的旅游计划
		Scanner scan = new Scanner(System.in);
		TravelBuilder builder2 = new VacationBuilder();
		System.out.println("please choose a date:");
		String date = scan.next();
		System.out.println("please choose a hotal:");
		String hotal = scan.next();
		System.out.println("please add money:");
		String money = scan.next();
		builder2.buildDate(date)
		   		.addHotal(hotal)
		   		.addMoney(money);
		System.out.println(builder2.getVacationPlanner());
	}
	
}
