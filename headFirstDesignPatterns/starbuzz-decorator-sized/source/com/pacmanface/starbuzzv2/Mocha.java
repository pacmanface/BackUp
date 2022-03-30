package com.pacmanface.starbuzzv2;

public class Mocha extends CondimentBeverage{
	
	public Mocha(Beverage b){
		beverage = b;
	}
	
	public String getDescription(){
		return beverage.getDescription() + ", Mocha";
	}
	
	public double cost(){
		double featuresCost=0;
		switch(beverage.getSize()){
			case TALL: featuresCost = 0.30; break;
			case GRANDE: featuresCost = 0.40; break;
			case VENTI: featuresCost = 0.50; break;
		}
		return featuresCost+beverage.cost();
	}
}
