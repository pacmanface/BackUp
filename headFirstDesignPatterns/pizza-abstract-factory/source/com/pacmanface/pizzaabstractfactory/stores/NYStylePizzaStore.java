package com.pacmanface.pizzaabstractfactory.stores;

import com.pacmanface.pizzaabstractfactory.*;
import com.pacmanface.pizzaabstractfactory.hubs.*;
import com.pacmanface.pizzaabstractfactory.pizzas.*;

public class NYStylePizzaStore extends PizzaStore{
	public Pizza createPizza(String type){
		IngredientFactory ingredientFactory = new NYIngredientFactory();
		Pizza pizza = null;
		switch(type){
			case "cheese": pizza = new NYStyleCheese(ingredientFactory);break;
			default: pizza = new NYStyleCheese(ingredientFactory);
		}
		return pizza;
	}
}
