package com.pacmanface.weatherstation;

import java.util.*;

public class StorageImpl implements Storage{
	
	private List<WeatherData> dataHistory;
	
	public WeatherData get(){
		return dataHistory.get(0);
	}				
	
	public void put(WeatherData wd){
		dataHistory.add(0,data);
	}	
}
