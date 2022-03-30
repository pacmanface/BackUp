package com.pacmanface.copatterns;

import com.pacmanface.copatterns.ducks.Goose;
import com.pacmanface.copatterns.lookat.Observable;
import com.pacmanface.copatterns.lookat.QuackObserver;

public class GooseAdapter implements Quack{
	
	private Goose goose;
	private Observable observable;
	
	public GooseAdapter(Goose g){
		goose = g;
		observable = new Observable(this);
	}
	
	@Override
	public void quack(){
		goose.honk();
		notifyObserver();
	}

	@Override
	public void notifyObserver() {
		observable.notifyObserver();
	}

	@Override
	public void registryObserver(QuackObserver o) {
		observable.registryObserver(o);
	}
}
