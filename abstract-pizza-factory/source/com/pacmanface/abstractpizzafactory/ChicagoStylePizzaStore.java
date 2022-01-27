package com.pacmanface.abstractpizzafactory;

public class ChicagoStylePizzaStore extends PizzaStore{
	public Pizza createPizza(String type){
		Pizza pizza = null;
		switch(type){
			case "cheese": pizza = new ChicagoStyleCheese();break;
			default: pizza = new ChicagoStyleCheese();
		}
		return pizza;
	}
}
