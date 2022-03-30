package com.pacmanface.weatherstation;

public class WeatherData{

	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData(float temperature, float humidity, float pressure){
		this.temperature=temperature;
		this.humidity=humidity;
		this.pressure=pressure;
	}
	
	@Override
	public String toString(){
		return "result: "+temperature+" C "+humidity+" % "+pressure+" p.m.";
	}
}
