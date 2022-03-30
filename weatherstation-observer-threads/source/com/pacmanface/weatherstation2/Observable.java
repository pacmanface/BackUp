package com.pacmanface.weatherstation2;

interface Observable{
	void addObserver(Observer o);
	void deleteObserver(Observer o);
	void notifyObservers();
	void notifyObserver(Observer o);
}
