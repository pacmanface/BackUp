package com.pacmanface.starbuzzv2;

public class Espresso extends Beverage{
	
	public String getString(){
		return "This is an "+getSize()+" Espresso";
	}
	
	public double cost(){
		double cost = 0;
		switch(getSize()){
			case TALL: cost = 1.60;break;
			case GRANDE: cost = 2.50;break;
			case VENTI: cost = 3.20;break;
		}
		return cost;
	}
}
