package com.pacmanface.copatterns.factories;

import com.pacmanface.copatterns.*;
import com.pacmanface.copatterns.ducks.*;

public class GooseFactory extends AbstractGooseFactory{
	@Override
	public Goose createGoose(){
		return new Goose();
	}
	
	@Override 
	public Quack createGooseAdapter(){
		return new GooseAdapter(createGoose());
	}
	
	@Override
	public Quack createGooseCounter(){
		return new QuackCounter(createGooseAdapter());
	}
}
