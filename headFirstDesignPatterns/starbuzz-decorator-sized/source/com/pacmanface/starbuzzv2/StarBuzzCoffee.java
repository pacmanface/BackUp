package com.pacmanface.starbuzzv2;

import com.pacmanface.starbuzzv2.Beverage.Size;

public class StarBuzzCoffee{
	public static void main(String[] args){
		Beverage decaf = new Decaf();
		decaf.setSize(Size.VENTI);
		decaf = new Mocha(decaf);
		decaf = new Milk(decaf);
		decaf = new Whip(decaf);
		System.out.println(decaf.getDescription()+"  $"+decaf.cost());
		
		Beverage dark = new DarkRoast();
		dark.setSize(Size.GRANDE);
		dark = new Milk(dark);
		dark = new Mocha(dark);
		System.out.println(dark.getDescription()+" $"+dark.cost());
		
		Beverage latte = new Whip(new Milk(new Mocha(new HouseBlend())));
		System.out.println(latte.getDescription()+" $"+latte.cost());
		
	}
}
