package com.pacmanface.pizzasimplefactory;

public class PizzaSimpleFactory{

	public static Pizza createPizza(String type){
		Pizza pizza = null;
		switch(type){
			case "Alfredo": pizza = new Alfredo(); break;
			case "Pepperoni": pizza = new Pepperoni(); break;
			case "Cheesee": pizza = new Cheesee(); break;
			default: pizza = new Pepperoni();
		}
		return pizza;
	}
}
