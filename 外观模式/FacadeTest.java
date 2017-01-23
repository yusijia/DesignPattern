package com.designPattern.facade;

public class FacadeTest {

	public static void main(String[] args) {
		Amplifier amp = new Amplifier();
		Projector pro = new Projector();
		Screen scr = new Screen();
		Curtain cur = new Curtain();
		
		HomeTheatre homeTheatre = new HomeTheatre(amp, pro, scr, cur);
		homeTheatre.watchMovie();
		System.out.println("=================我是分割线==================");
		homeTheatre.closeMovie();
	}
	
}
