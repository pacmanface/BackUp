package com.pacmanface.copatterns;

import java.util.*;
import com.pacmanface.copatterns.lookat.*;

public class Flock implements Quack{
	
	ArrayList<Quack> quackers = new ArrayList<>();
	
	public void addQuacker(Quack... quacker){
		for(Quack q : quacker) quackers.add(q);
	}
	
	@Override
	public void quack(){
		Iterator<Quack> iterator = quackers.iterator();
		while(iterator.hasNext()){
			Quack q = iterator.next();
			q.quack();
		}
	}
	
	@Override
	public void registryObserver(QuackObserver o) {
		Iterator<Quack> iterator = quackers.iterator();
		while(iterator.hasNext()){
			Quack q = iterator.next();
			q.registryObserver(o);
		}
	}

	@Override
	public void notifyObserver() {
		Iterator<Quack> iterator = quackers.iterator();
		while(iterator.hasNext()){
			Quack q = iterator.next();
			q.notifyObserver();
		}
	}
}
