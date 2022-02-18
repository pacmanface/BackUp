package com.pacmanface.cafe;

public class TestCafe{
	public static void main(String[]args){
		PancakeHouseMenu pancakes = new PancakeHouseMenu();
		SandwichPalaceMenu sandwiches = new SandwichPalaceMenu();
	
		Waitress waitress = new Waitress(pancakes,sandwiches);
		waitress.printMenu();
	}
}
