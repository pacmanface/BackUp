package com.pacmanface.starbuzzv2;

public abstract class Beverage{
	
	public enum Size{TALL, GRANDE, VENTI}

	private Size size = Size.TALL;
	
	private String description = "unnamed beverage";
	
	public String getDescription(){
		return description;
	}
	
	public Size getSize(){
		return size;
	}
	
	public void setSize(Size s){
		size = s;
	}
	
	public abstract double cost();
}
