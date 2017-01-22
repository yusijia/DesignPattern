package com.designPattern.command;

/**
 * 空命令对象 什么也不操作 仅仅用于初始化
 * @author ysj
 *
 */
public class NoCommand implements Command{

	@Override
	public void execute() {	}

	@Override
	public void undo() { }

	
	
}
