package com.pacmanface.starbuzzv2;

public class Decaf extends Beverage{

	public String getDescription(){
		return "This is a "+getSize()+" Decaf";
	}
	
	public double cost(){
		double cost = 0;
		switch(getSize()){
			case TALL: cost = 1.05;break;
			case GRANDE: cost = 1.55;break;
			case VENTI: cost = 1.95;break;
		}
		return cost;
	}
}
