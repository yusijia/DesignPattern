package com.designPattern.state;

import java.util.Random;

/**
 * 已投入25分钱的状态
 * @author ysj
 *
 */
public class HasQuarterState implements State {

	Random randomWinner = new Random(System.currentTimeMillis());
	GumballMachine gumballMachine;
	
	
	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
  
	@Override
	public void insertQuarter() {
		System.out.println("You can't insert another quarter");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Quarter returned");
		// 设置机器状态
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned...");
		int winner = randomWinner.nextInt(10);
		if ((winner == 0) && (gumballMachine.getCount() > 1)) {
			// 设置机器的状态为幸运赢家状态
			gumballMachine.setState(gumballMachine.getWinnerState());
		} else {
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}

	@Override
	public void dispense() {
		System.out.println("No gumball dispensed");
	}

	@Override
	public String toString(){
		return "waiting for turn of crank";
	}
	
}
