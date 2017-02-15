package com.designPattern.builder;

public interface TravelBuilder {

	/**
	 * 创建一个默认的计划
	 * @return
	 */
	Planner getDefaultVacationPlanner();
	
	/**
	 * 将用户的要求添加到计划里并返回计划
	 * @return
	 */
	Planner getVacationPlanner();
	
	/**
	 * 指定旅游的日期到计划里
	 * @param data
	 * @return
	 */
	TravelBuilder buildDate(String data);

	/**
	 * 添加旅游时的住所到计划里
	 * @param hotal
	 * @return
	 */
	TravelBuilder addHotal(String hotal);

	/**
	 * 添加旅游经费到计划里
	 * @param money
	 * @return
	 */
	TravelBuilder addMoney(String money);

}
