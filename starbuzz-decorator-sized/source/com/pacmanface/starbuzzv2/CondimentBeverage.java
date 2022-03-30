package com.pacmanface.starbuzzv2;

public abstract class CondimentBeverage extends Beverage{	
	public Beverage beverage;
	public abstract String getDescription();
	public Size getSize(){
		return beverage.getSize();
	}
}
