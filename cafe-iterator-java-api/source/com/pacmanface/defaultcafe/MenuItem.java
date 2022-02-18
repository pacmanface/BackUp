package com.pacmanface.defaultcafe;

public class MenuItem {
	String name;
	String description;
	boolean isVegetarian;
	double price;
	
	public MenuItem(String n, String d, boolean b, double p){
		name=n;
		description=d;
		isVegetarian=b;
		price=p;
	}
	
	public String getName(){
		return name;
	}

	@Override
	public String toString(){
		return name+" "+description+" "+isVegetarian+" "+price;
	}
}
