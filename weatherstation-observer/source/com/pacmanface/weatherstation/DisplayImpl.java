package com.pacmanface.weatherstation;

public class DisplayImpl implements Display{
	
	public void display(WeatherData data){
		System.out.println(data.toString());	
	}
}
