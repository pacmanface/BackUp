package com.pacmanface.pizzaabstractfactory.stores;

import com.pacmanface.pizzaabstractfactory.*;
import com.pacmanface.pizzaabstractfactory.hubs.*;
import com.pacmanface.pizzaabstractfactory.pizzas.*;

public class ChicagoStylePizzaStore extends PizzaStore{
	
	public Pizza createPizza(String type){
		IngredientFactory ingredientFactory = new ChicagoIngredientFactory();
		Pizza pizza = null;
		switch(type){
			case "cheese": pizza = new ChicagoStyleCheese(ingredientFactory);break;
			default: pizza = new ChicagoStyleCheese(ingredientFactory);
		}
		return pizza;
	}
}
