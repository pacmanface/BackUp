package com.pacmanface.weatherstation2;

import java.util.*;

public class WeatherDataObservable implements Observable,Runnable{

	private ArrayList<Observer> observers = new ArrayList<>();
	public static volatile boolean isActual;
	
	public WeatherDataObservable(){
	}
	
	@Override
	public void run() {
		while(true){
			try {
				checkData();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		} 
	}

	public void checkData(){
		if(!isActual) notifyObservers();
	}

	public void addObserver(Observer o){
		observers.add(o);
		notifyObserver(o);
	}
	
	public void deleteObserver(Observer o){
		if(!observers.isEmpty()){		
			try{
				observers.remove(o);
			}catch(Exception ex){
				System.out.println("can't find the observer!");
				ex.printStackTrace();
			}
		}else System.out.println("no observers");	
	}
	
	public void notifyObservers(){
		if(!observers.isEmpty()){
			for(Observer o:observers){
				o.update();
			}
			isActual=true;		
		}else System.out.println("Noone to notify");
	}
	
	public void notifyObserver(Observer o){
		o.update();
	}
}
