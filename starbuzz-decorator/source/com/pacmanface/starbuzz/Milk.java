package com.pacmanface.starbuzz;

public class Milk extends CondimentBeverage{
	
	private Beverage beverage;
	
	public Milk(Beverage b){
		beverage = b;
	}
	
	public String getDescription(){
		return beverage.getDescription() + ", Milk";
	}
	
	public double cost(){
		return 0.10+beverage.cost();
	}
}
