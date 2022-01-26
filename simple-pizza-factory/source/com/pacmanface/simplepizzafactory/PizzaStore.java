package com.pacmanface.simplepizzafactory;

public class PizzaStore{
	
    public orderPizza(String type){
		Pizza pizza = createPiza(type);
		pizza.prepare();
		pizza.cut();
		pizza.pack();
		pizza.deliver();
	}	
}
