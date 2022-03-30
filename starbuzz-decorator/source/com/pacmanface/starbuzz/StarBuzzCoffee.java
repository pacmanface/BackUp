package com.pacmanface.starbuzz;

public class StarBuzzCoffee{
	public static void main(String[] args){
		Beverage beverage = new Decaf();
		System.out.println(beverage.getDescription()+"  $"+beverage.cost());
		
		Beverage beverage2 = new DarkRoast();
		beverage2 = new Milk(beverage2);
		beverage2 = new Mocha(beverage2);
		System.out.println(beverage.getDescription()+" $"+beverage.cost());
		
		Beverage latte = new Whip(new Milk(new Mocha(new HouseBlend())));
		System.out.println(latte.getDescription()+" $"+latte.cost());
	}
}
