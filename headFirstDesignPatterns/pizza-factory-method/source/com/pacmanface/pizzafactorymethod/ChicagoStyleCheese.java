package com.pacmanface.pizzafactorymethod;

public class ChicagoStyleCheese extends Pizza{
	public ChicagoStyleCheese(){
		name="Chicago Style Cheese Pizza";
		souce="standard tomato spice";
		toppings.add("Mozarella side");
		toppings.add("Marinade cucumber slices");
		toppings.add("sweet marinade chily pepper");
	}
	
	@Override
	public void cut(){
		System.out.println("cut "+name+" to stripces");
	}
}
