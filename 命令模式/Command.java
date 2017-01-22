package com.designPattern.command;

public interface Command {
	
	/**
	 * 运行命令
	 */
	public void execute();
	
	/**
	 * 撤销命令,并回退到上一个状态
	 */
	public void undo();
	
}
