package com.pacmanface.pizzasimplefactory;

public class PizzaStore{
	
    public void orderPizza(String type){
		Pizza pizza = PizzaSimpleFactory.createPizza(type);
		pizza.prepare();
		pizza.cut();
		pizza.pack();
		pizza.delivery();
	}	
}
