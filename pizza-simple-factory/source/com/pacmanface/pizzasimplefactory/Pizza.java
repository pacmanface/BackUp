package com.pacmanface.pizzasimplefactory;

public abstract class Pizza{
	
	String type; 
	
	public void prepare(){
		System.out.println(type+" preparing");
	}
	
	public void cut(){
		System.out.println(type+" cutting");
	}
	
	void pack(){
		System.out.println(type+" packing");
	}
	
	void delivery(){
		System.out.println("take your "+type+" sir");
	}
}
