package com.pacmanface.starbuzzv2;

public class HouseBlend extends Beverage{

	public String getDescription(){
		return "This is a "+getSize()+" House blend";
	}
	
	public double cost(){
		double cost = 0;
		switch(getSize()){
			case TALL: cost = 0.89;break;
			case GRANDE: cost = 1.20;break;
			case VENTI: cost = 1.70;break;
		}
		return cost;
	}
}
