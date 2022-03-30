package com.pacmanface.starbuzzv2;

public class Milk extends CondimentBeverage{
	
	public Milk(Beverage b){
		beverage = b;
	}
	
	public String getDescription(){
		return beverage.getDescription() + ", Milk";
	}
	
	public double cost(){
		double featureCost=0;
		switch(beverage.getSize()){
			case TALL: featureCost = 0.10; break;
			case GRANDE: featureCost = 0.15; break;
			case VENTI: featureCost = 0.20; break;
		}
		return featureCost+beverage.cost();
	}
}
