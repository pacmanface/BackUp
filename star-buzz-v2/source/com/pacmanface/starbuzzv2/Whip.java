package com.pacmanface.starbuzzv2;

public class Whip extends CondimentBeverage{
	
	public Whip(Beverage b){
		beverage = b;
	}
	
	public String getDescription(){
		return beverage.getDescription() + ", Whip";
	}
	
	public double cost(){
	double featuresCost = 0;
		switch(beverage.getSize()){
			case TALL: featuresCost = 0.05; break;
			case GRANDE: featuresCost = 0.10; break;
			case VENTI: featuresCost = 0.15; break;
		}
		return featuresCost+beverage.cost();
	}
}
