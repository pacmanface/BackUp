package com.pacmanface.weatherstation;

import java.util.*;

public class WeatherDataSubject implements Subject{

	private ArrayList<Observer> observers = new ArrayList<>();
	private WeatherData data;
	
	public WeatherDataSubject(){
	}
	
	public void registerObserver(Observer o){
		observers.add(o);
		notifyObservers();
	}
	
	public void removeObserver(Observer o){
		if(!observers.isEmpty()){		
			try{
				observers.remove(o);
				notifyObservers();
			}catch(Exception ex){
				System.out.println("the observer was not registered!");
				ex.printStackTrace();
			}
		}else System.out.println("no observers");	
	}
	
	public void notifyObservers(){
		if(!observers.isEmpty()){
			for(Observer o:observers){
				if(data!=null) o.update(data);
				else System.out.println("nodata");
			}
		}else System.out.println("no observers");
	}
	
	public void transmit(WeatherData data){
		this.data = data;
		notifyObservers();
	}		
}
