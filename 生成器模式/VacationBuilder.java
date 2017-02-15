package com.designPattern.builder;

public class VacationBuilder implements TravelBuilder {

	private Planner plan;
	
	public VacationBuilder(){
		plan = new Planner();
	}
	
	@Override
	public Planner getDefaultVacationPlanner() {
		plan.buildDate("周末");
		plan.addHotal("7天连锁酒店");
		plan.addMoney("2000");
		return plan;
	}

	@Override
	public Planner getVacationPlanner() {
		return plan;
	}

	@Override
	public TravelBuilder buildDate(String date) {
		plan.buildDate(date);
		return this;
	}

	@Override
	public TravelBuilder addHotal(String hotal) {
		plan.addHotal(hotal);
		return this;
	}

	@Override
	public TravelBuilder addMoney(String money) {
		plan.addMoney(money);
		return this;
	}

}
