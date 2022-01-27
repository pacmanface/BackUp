package com.pacmanface.simplepizzafactory;

public class PizzaStore{
	
    public void orderPizza(String type){
		Pizza pizza = SimplePizzaFactory.createPizza(type);
		pizza.prepare();
		pizza.cut();
		pizza.pack();
		pizza.deliver();
	}	
}
