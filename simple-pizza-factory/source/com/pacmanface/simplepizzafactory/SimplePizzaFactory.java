package com.pacmanface.simplepizzafactory;

public class SimplePizzaFactory{

	public Pizza createPizza(String type){
		Pizza pizza = null;
		switch(type){
			case "Alfredo": pizza = new Alfredo(); break;
			case "Pepperoni": pizza = new Pepperony(); break;
			case "Cheese": pizza = new Cheese(); break;
			default: pizza = new Pepperony();
		}
		return pizza;
	}
}
