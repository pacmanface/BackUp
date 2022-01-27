package com.pacmanface.abstractpizzafactory;

public class NYStylePizzaStore extends PizzaStore{
	public Pizza createPizza(String type){
		Pizza pizza = null;
		switch(type){
			case "cheese": pizza = new NYStyleCheese();break;
			default: pizza = new NYStyleCheese();
		}
		return pizza;
	}
}
