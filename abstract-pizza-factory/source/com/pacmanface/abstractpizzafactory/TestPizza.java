package com.pacmanface.abstractpizzafactory;

public class TestPizza{
	public static void main(String[]args){
		PizzaStore nyStore = new NYStylePizzaStore();
		PizzaStore chicagoStore = new ChicagoStylePizzaStore();
		
		nyStore.orderPizza("cheese");
		chicagoStore.orderPizza("cheese");
	}
}
