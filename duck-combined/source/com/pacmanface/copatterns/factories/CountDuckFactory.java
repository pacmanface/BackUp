package com.pacmanface.copatterns.factories;

import com.pacmanface.copatterns.*;
import com.pacmanface.copatterns.ducks.*;

public class CountDuckFactory extends AbstractDuckFactory{

	@Override
	public Quack createMallardDuck(){
		return new QuackCounter(new MallardDuck());
	}
	
	@Override
	public Quack createRedHeadDuck(){
		return new QuackCounter(new RedHeadDuck());
	}
	
	@Override
	public Quack createRubberDuck(){
		return new QuackCounter(new RubberDuck());
	}
	
	@Override
	public Quack createDuckCall(){
		return new QuackCounter(new DuckCall());
	}
}
