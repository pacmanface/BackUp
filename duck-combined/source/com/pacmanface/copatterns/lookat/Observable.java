package com.pacmanface.copatterns.lookat;

import java.util.ArrayList;
import java.util.Iterator;

public class Observable implements QuackObservable{

	QuackObservable quacker;
	ArrayList<QuackObserver> observers = new ArrayList<>();

	public Observable(QuackObservable qo){
		quacker = qo;
	}

	@Override
	public void registryObserver(QuackObserver o) {
		observers.add(o);
	}

	@Override
	public void notifyObserver() {
		Iterator<QuackObserver> iterator = observers.iterator();
		while(iterator.hasNext()){
			QuackObserver observer = iterator.next();
			observer.update(quacker);
		}
	}
}
