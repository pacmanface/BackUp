package com.pacmanface.starbuzz;

public class Whip extends CondimentBeverage{
	
	private Beverage beverage;
	
	public Whip(Beverage b){
		beverage = b;
	}
	
	public String getDescription(){
		return beverage.getDescription() + ", Whip";
	}
	
	public double cost(){
		return 0.20+beverage.cost();
	}
}
