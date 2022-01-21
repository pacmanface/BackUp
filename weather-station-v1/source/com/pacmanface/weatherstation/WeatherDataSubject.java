package com.pacmanface.weatherstation;

import java.util.*;

public class WeatherDataSubject implements Subject{

	private List<Observer> observers;
	private Storage storage;
	
	public WeatherDataSubject(){
		observers = new ArrayList();
		storage = new StorageImpl();
	}
	
	public void setData(WeatherData data){
		storage.put(data);
		notify();
	}
	
	public void registerObserver(Observer o){
		observers.add(o);
		notify();
	}
	
	public void removeObserver(Observer o){
		try{
			int i = observers.indexOf(o);
			observers.remove(i);
			notify();
		}catch(Exception ex){
			System.out.println("the observer was not registered!");
			ex.printStackTrace();
		}	
	}
	
	public void notify(){
		if(!observers.isEmpty()){
			for(Observer o:observers){
				o.update();
			}
		}
	}		
}
