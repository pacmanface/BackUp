package com.pacmanface.pizzaabstractfactory;

import com.pacmanface.pizzaabstractfactory.stores.*;

public class TestPizza{
	public static void main(String[]args){
		PizzaStore nyStore = new NYStylePizzaStore();
		PizzaStore chicagoStore = new ChicagoStylePizzaStore();
		
		nyStore.orderPizza("cheese");
		chicagoStore.orderPizza("cheese");
	}
}
