package com.pacmanface.pizzaabstractfactory.pizzas;

import com.pacmanface.pizzaabstractfactory.IngredientFactory;
import com.pacmanface.pizzaabstractfactory.Pizza;

public class ChicagoStyleCheese extends Pizza{
	
	public ChicagoStyleCheese(IngredientFactory i){
		name="Chicago Style Cheese Pizza";
		ingredientFactory = i;
	}
	
	public void cook(){
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
	}

	@Override
	public void cut(){
		System.out.println("cut "+name+" to stripces");
	}
}
