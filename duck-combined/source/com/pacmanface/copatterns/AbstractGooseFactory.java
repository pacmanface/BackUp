package com.pacmanface.copatterns;

public abstract class AbstractGooseFactory{
	abstract Goose createGoose();
	abstract Quack createGooseAdapter();
	abstract Quack createGooseCounter();
}
