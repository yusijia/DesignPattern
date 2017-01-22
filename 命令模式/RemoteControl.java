package com.designPattern.command;

/**
 * 命令模式
 *   将请求封装成对象，使不同的请求、日志、队列来参数化其他对象。
 * @author ysj
 *
 */
public class RemoteControl {
	
	public static int num = 7;
	
	private Command[] onCommands;
	private Command[] offCommands;
	
	/**
	 * 执行的最后一条命令
	 */
	private Command lastCommand;
	
	/**
	 * 初始化
	 */
	public RemoteControl(){
		onCommands = new Command[num];
		offCommands = new Command[num];
		Command noCommand = new NoCommand();
		for(int i = 0; i < num; i++){
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
		lastCommand = noCommand;
	}
	
	/**
	 * 设置按键功能
	 * @param position
	 * @param onCommand
	 * @param offCommand
	 */
	public void setCommand(int position, Command onCommand, Command offCommand){
		onCommands[position] = onCommand;
		offCommands[position] = offCommand;
	}
	
	/**
	 * 开
	 * @param slot
	 */
	public void onButtonWasPushed(int position) {
		onCommands[position].execute();
		lastCommand = onCommands[position];
	}
 
	/**
	 * 关
	 * @param slot
	 */
	public void offButtonWasPushed(int position) {
		offCommands[position].execute();
		lastCommand = offCommands[position];
	}

	/**
	 * 撤销按钮
	 */
	public void undoButtonWasPushed() {
		lastCommand.undo();
	}
	
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control -------\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
				+ "    " + offCommands[i].getClass().getName() + "\n");
		}
		stringBuff.append("[undo] " + lastCommand.getClass().getName() + "\n");
		return stringBuff.toString();
	}
}
