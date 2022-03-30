package com.pacmanface.simuduck;

public class ToyDuck extends Duck{
	
	public ToyDuck(){
		fb = new NoFly();
		qb = new Squeak();
	}
	
	public void display(){
		System.out.println("Life in plastic, so fantastic");
	}	
}
