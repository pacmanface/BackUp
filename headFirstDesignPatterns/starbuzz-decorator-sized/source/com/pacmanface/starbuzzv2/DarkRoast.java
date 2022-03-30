package com.pacmanface.starbuzzv2;

public class DarkRoast extends Beverage{
	
	public String getDescription(){
		return "This is a " +getSize()+" DarkRoast blend";
	}
	
	public double cost(){
		double cost = 0;
		switch(getSize()){
			case TALL: cost = 1.10;
			case GRANDE: cost = 1.50;
			case VENTI: cost = 1.90;
		}
		return cost;
	}
}
