package com.pacmanface.starbuzzv2;

public class Soy extends CondimentBeverage{
	
	public Soy(Beverage b){
		beverage = b;
	}
	
	public String getDescription(){
		return beverage.getDescription() + ", Soy";
	}
	
	public double cost(){
	double featuresCost = 0;
		switch(beverage.getSize()){
			case TALL: featuresCost = 0.20; break;
			case GRANDE: featuresCost = 0.30; break;
			case VENTI: featuresCost = 0.40; break;
		}
		return featuresCost+beverage.cost();
	}
}
