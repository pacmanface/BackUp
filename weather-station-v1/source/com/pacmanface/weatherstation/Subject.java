package com.pacmanface.weatherstation;

interface Subject{
	void registerObserver(Observer o);
	void removeObserver(Observer o);
	void notify();
}
