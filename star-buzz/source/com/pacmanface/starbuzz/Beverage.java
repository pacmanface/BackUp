package com.pacmanface.starbuzz;

public abstract class Beverage{
	
	private String description = "unnamed beverage";
	
	public String getDescription(){
		return description;
	}
	
	public abstract double cost();
}
