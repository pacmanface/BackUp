package com.pacmanface.simplepizzafactory;

public class SimplePizzaFactory{

	public static Pizza createPizza(String type){
		Pizza pizza = null;
		switch(type){
			case "Alfredo": pizza = new Alfredo(); break;
			case "Pepperoni": pizza = new Pepperoni(); break;
			case "Cheese": pizza = new Cheesee(); break;
			default: pizza = new Pepperoni();
		}
		return pizza;
	}
}
