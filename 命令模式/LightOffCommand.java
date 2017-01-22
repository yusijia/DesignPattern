package com.designPattern.command;

/**
 * 关灯命令
 * @author ysj
 *
 */
public class LightOffCommand implements Command{

	private Light light;
	
	public LightOffCommand(Light light){
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.off();
	}

	@Override
	public void undo() {
		light.on();
	}

	
	
}
