package com.pacmanface.copatterns;

import com.pacmanface.copatterns.lookat.QuackObserver;

public class QuackCounter implements Quack{
	
	private Quack quacker;
	public static int quackJob = 0;
	
	public QuackCounter(Quack q){
		quacker = q;
	}
	
	@Override
	public void quack(){
		quacker.quack();
		notifyObserver();
		count();	
	}
	
	private void count(){
		quackJob++;
	}

	@Override
	public void registryObserver(QuackObserver o) {
		quacker.registryObserver(o);
	}

	@Override
	public void notifyObserver() {
		quacker.notifyObserver();
	}
}
