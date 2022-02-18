package com.pacmanface.weatherstation2;



public class CurrentDataObserver implements Observer{
	
	public CurrentDataObserver(Observable observable){
		observable.addObserver(this);
	}

	public void update(){
		int i = WeatherData.DATA_LIST.size()-1;
		if(i>0) System.out.println(WeatherData.DATA_LIST.get(i));
		else System.out.println("no data");
	}
}
