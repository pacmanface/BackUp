package com.pacmanface.copatterns.ducks;

import com.pacmanface.copatterns.Quack;
import com.pacmanface.copatterns.lookat.Observable;
import com.pacmanface.copatterns.lookat.QuackObserver;

public class MallardDuck implements Quack{
	
	Observable observable;
	
	public MallardDuck(){
		observable = new Observable(this);
	}

	@Override
	public void registryObserver(QuackObserver o) {
		observable.registryObserver(o);
	}

	@Override
	public void notifyObserver() {
		observable.notifyObserver();
	}

	@Override
	public void quack(){
		System.out.println("quack");
		notifyObserver();
	}
}
