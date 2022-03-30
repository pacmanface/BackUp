package com.pacmanface.pizzaabstractfactory;

import com.pacmanface.pizzaabstractfactory.ingredients.*;

public abstract class Pizza{

	public String name;
	public IngredientFactory ingredientFactory;
	
	public Dough dough;
	public Sauce sauce;
	public Cheese cheese;
	public Clam clam;
	public Pepperoni pepperoni;
	public Veggis[] veggis;

	public abstract void cook();
	
	public void bake(){
		System.out.println("bake "+name+" 15 min. in 350 degrese oven.");
	}
	
	public void cut(){
		System.out.println("cut "+name+" to 8 slices.");
	}
	
	public void pack(){
		System.out.println("pack "+name+" in branded package.");
	}
	
	public void delivery(){
		System.out.println("your "+name+" sir.");
		System.out.println(this.toString()+" sir.");
		System.out.println("Thank you!");
	}

	@Override
	public String toString() {
		StringBuilder pizzaCheck = new StringBuilder();
		pizzaCheck.append(dough.getClass().getSimpleName());
		pizzaCheck.append(", ");
		pizzaCheck.append(sauce.getClass().getSimpleName());
		pizzaCheck.append(", ");
		if(cheese!=null) pizzaCheck.append(cheese.getClass().getSimpleName()+", ");
		if(pepperoni!=null) pizzaCheck.append(pepperoni.getClass().getSimpleName()+", ");
		if(clam!=null) pizzaCheck.append(clam.getClass().getSimpleName()+", ");
		if(veggis!=null){
			for (Veggis veg : veggis) {
				pizzaCheck.append(veg.getClass().getSimpleName()+", ");		
			}
		} 
		return String.valueOf(pizzaCheck); 
	}
}
