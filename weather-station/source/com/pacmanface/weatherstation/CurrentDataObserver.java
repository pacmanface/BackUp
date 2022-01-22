package com.pacmanface.weatherstation;

public class CurrentDataObserver implements Observer{
	
	private Display display;
	
	public CurrentDataObserver(Subject s, Display d){
		display = d;
		s.registerObserver(this);
	}

	public void update(WeatherData data){
		display.display(data);
	}
}
