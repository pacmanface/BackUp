package com.pacmanface.pizzafactorymethod;

import java.util.*;

public abstract class Pizza{
	
	String name;
	String souce;
	
	ArrayList<String> toppings = new ArrayList<>();
	
	public void cook(){
		System.out.println("add "+souce+" to the "+name);
		for(String topping:toppings){
			System.out.println("add "+topping);
		}
	}
	
	public void bake(){
		System.out.println("bake "+name+" 15 min. in 350 degrese oven.");
	}
	
	public void cut(){
		System.out.println("cut "+name+" to 8 slices.");
	}
	
	public void pack(){
		System.out.println("pack "+name+" in branded package.");
	}
	
	public void delivery(){
		System.out.println("your "+name+" sir. Thank you.");
	}

}
