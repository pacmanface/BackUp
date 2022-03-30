package com.pacmanface.simuduck;

public class BronzeDeskDuck extends Duck{
	
	public BronzeDeskDuck(){
		fb = new NoFly();
		qb = new MuteQuack();
	}
	
	public void display(){
		System.out.println("Yo, I am the desk bronze duck");
	}
	
	@Override
	public void swim(){
		System.out.println("Don't even think about it!");
	}
}
