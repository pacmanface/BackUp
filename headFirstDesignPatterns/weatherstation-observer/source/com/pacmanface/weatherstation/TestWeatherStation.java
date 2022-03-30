package com.pacmanface.weatherstation;

public class TestWeatherStation{
	
	public static void main(String[]args){
		WeatherData data = new WeatherData(1,70,700);
		Display disp = new DisplayImpl();
		WeatherDataSubject subj = new WeatherDataSubject();
		Observer observer = new CurrentDataObserver(subj, disp);
				
		
		subj.transmit(data);
		data = new WeatherData(2,50,750);
		subj.transmit(data);		
	}
}
