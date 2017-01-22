package com.designPattern.command;

public class CommandTest {

	public static void main(String[] args) {
		
		RemoteControl remoteControl = new RemoteControl();

		Light light = new Light("Living Room");
		LightOnCommand lightOn = new LightOnCommand(light);
		LightOffCommand lightOff = new LightOffCommand(light);
		
		remoteControl.setCommand(0, lightOn, lightOff);
		  
		System.out.println(remoteControl);
		System.out.println("--- Pushing Macro On---");
		remoteControl.onButtonWasPushed(0);
		System.out.println("--- Pushing Macro Off---");
		remoteControl.offButtonWasPushed(0);
	}
	
}
