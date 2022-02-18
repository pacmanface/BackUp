package com.pacmanface.simuduck;

abstract class Duck{

	FlyBehavior fb;
	QuackBehavior qb;
	
	abstract void display();
	
	public void performFly(){
		fb.fly();
	}	
	
	public void performQuack(){
		qb.quack();	
	}
	
	public void swim(){
		System.out.println("Yes, we all can swim!");
	}
	
	public void setFlyBehavior(FlyBehavior flyBehavior){
		fb = flyBehavior;
	}
	
	public void setQuackBehavior(QuackBehavior quackBehavior){
		qb = quackBehavior;
	}
}
