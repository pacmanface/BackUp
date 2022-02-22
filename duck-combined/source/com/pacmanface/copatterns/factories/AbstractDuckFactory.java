package com.pacmanface.copatterns.factories;

import com.pacmanface.copatterns.*;

public abstract class AbstractDuckFactory {
	public abstract Quack createMallardDuck();
	public abstract Quack createRedHeadDuck();
	public abstract Quack createRubberDuck();
	public abstract Quack createDuckCall();
}
