package com.pacmanface.copatterns.ducks;

import com.pacmanface.copatterns.Quack;
import com.pacmanface.copatterns.lookat.Observable;
import com.pacmanface.copatterns.lookat.QuackObserver;

public class RubberDuck implements Quack{
	
	Observable observable;

	public RubberDuck(){
		observable = new Observable(this);
	}

	@Override
	public void quack(){
		System.out.println("squeez");
	}

	@Override
	public void registryObserver(QuackObserver o) {
		observable.registryObserver(o);
	}

	@Override
	public void notifyObserver() {
		observable.notifyObserver();
	}
}
