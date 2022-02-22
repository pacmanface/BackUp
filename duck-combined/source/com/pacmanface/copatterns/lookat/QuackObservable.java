package com.pacmanface.copatterns.lookat;

public interface QuackObservable {
    void registryObserver(QuackObserver o);
	void notifyObserver();
}
