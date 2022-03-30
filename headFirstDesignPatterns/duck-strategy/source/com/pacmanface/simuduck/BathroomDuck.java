package com.pacmanface.simuduck;

public class BathroomDuck extends Duck{
	
	public BathroomDuck(){
		fb = new NoFly();
		qb = new Squeak();
	}	
	
	public void display(){
		System.out.println("Hi I'm bathroom duck");
	}
	
}
