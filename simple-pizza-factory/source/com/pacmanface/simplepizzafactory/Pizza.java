package com.pacmanface.simplepizzafactory;

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
	
	void deliver(){
		System.out.println("take your "+type+" sir");
	}
}
