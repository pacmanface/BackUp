package com.pacmanface.componentcafe;

public class MenuItem extends MenuComponent{
	
	public boolean isVegetarian;
	public double price;
	
	public MenuItem(String n, String d, boolean b, double p){
		name=n;
		description=d;
		isVegetarian=b;
		price=p;
	}
	
	@Override
	public void print(){
		System.out.println(this.toString());
	}

	@Override
	public String toString(){
		return name+" "+description+" "+isVegetarian+" "+price;
	}
}
