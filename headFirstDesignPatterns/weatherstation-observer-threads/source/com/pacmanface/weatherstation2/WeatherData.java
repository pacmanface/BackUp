package com.pacmanface.weatherstation2;

import java.util.*;

public class WeatherData{

	private float temperature;
	private float humidity;
	private float pressure;
	public static final ArrayList<WeatherData> DATA_LIST = new ArrayList<>();
	
	public WeatherData(float temperature, float humidity, float pressure){
		this.temperature=temperature;
		this.humidity=humidity;
		this.pressure=pressure;
		DATA_LIST.add(this);
		WeatherDataObservable.isActual=false;
	}
	
	@Override
	public String toString(){
		return "result: "+temperature+" C "+humidity+" % "+pressure+" p.m.";
	}

}
