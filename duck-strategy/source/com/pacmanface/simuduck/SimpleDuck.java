package com.pacmanface.simuduck;

public class SimpleDuck extends Duck{

	public SimpleDuck(){
		fb = new FlyWithWings();
		qb = new Quack();
	}
	
	public void display(){
		System.out.println("sooo simple");
	}
}
