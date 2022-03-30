package com.pacmanface.pizzaabstractfactory.pizzas;

import com.pacmanface.pizzaabstractfactory.*;

public class NYStyleCheese extends Pizza{
	public NYStyleCheese(IngredientFactory i){
		name="NY Style Cheese Pizza";
		ingredientFactory = i;
	}

	@Override
	public void cook() {
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
	}
}
