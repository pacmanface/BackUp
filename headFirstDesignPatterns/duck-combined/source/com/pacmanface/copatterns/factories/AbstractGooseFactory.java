package com.pacmanface.copatterns.factories;

import com.pacmanface.copatterns.*;
import com.pacmanface.copatterns.ducks.*;

public abstract class AbstractGooseFactory{
	public abstract Goose createGoose();
	public abstract Quack createGooseAdapter();
	public abstract Quack createGooseCounter();
}
