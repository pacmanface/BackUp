package com.pacmanface.weatherstation2;

public class TestWeatherStation{
	
	public static void main(String[]args){
		WeatherDataObservable observable = new WeatherDataObservable();
		
		Thread thread = new Thread(observable);
		thread.setDaemon(true);
		thread.run();
		
		Observer observer = new CurrentDataObserver(observable);
		WeatherData data = new WeatherData(1,70,700);
		data = new WeatherData(2,50,750);
	}
}
