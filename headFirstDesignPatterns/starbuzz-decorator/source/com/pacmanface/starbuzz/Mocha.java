package com.pacmanface.starbuzz;

public class Mocha extends CondimentBeverage{
	
	private Beverage beverage;
	
	public Mocha(Beverage b){
		beverage = b;
	}
	
	public String getDescription(){
		return beverage.getDescription() + ", Mocha";
	}
	
	public double cost(){
		return 0.30+beverage.cost();
	}
}
