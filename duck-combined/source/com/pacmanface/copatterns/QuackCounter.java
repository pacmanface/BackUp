package com.pacmanface.copatterns;

public class QuackCounter implements Quack{
	
	private Quack quacker;
	public static int quackJob = 0;
	
	public QuackCounter(Quack q){
		quacker = q;
	}
	
	@Override
	public void quack(){
		quacker.quack();
		count();	
	}
	
	private void count(){
		quackJob++;
	}
}
