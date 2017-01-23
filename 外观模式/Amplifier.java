package com.designPattern.facade;

/**
 * 扩音器
 * @author ysj
 *
 */
public class Amplifier {

	 public void openAmp(){
		 System.out.println("打开功放");
	 }
	
	 public void closeAmp(){
		 System.out.println("关闭功放");
	 }
	 
	 public void setVolume(int volume){
		 System.out.println("设置音量为"+5);
	 }
	 
	 public void setPlayer(int num){
		 switch (num) {
			case 1:
				System.out.println("设置CD播放");
				break;
			default:
				System.out.println("设置DVD播放");
				break;
		}
	 }
	
}
