package com.pacmanface.starbuzz;


public class Soy extends CondimentBeverage{
	
	private Beverage beverage;
	
	public Soy(Beverage b){
		beverage = b;
	}
	
	public String getDescription(){
		return beverage.getDescription() + ", Soy";
	}
	
	public double cost(){
		return 0.15+beverage.cost();
	}
}
