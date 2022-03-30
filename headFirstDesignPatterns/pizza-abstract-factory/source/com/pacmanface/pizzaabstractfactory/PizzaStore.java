package com.pacmanface.pizzaabstractfactory;

public abstract class PizzaStore{

	public void orderPizza(String type){
		Pizza pizza = createPizza(type);		
		pizza.cook();
		pizza.bake();
		pizza.cut();
		pizza.pack();
		pizza.delivery();			
	}
	
	public abstract Pizza createPizza(String type);
}
