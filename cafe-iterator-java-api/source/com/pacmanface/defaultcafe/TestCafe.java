package com.pacmanface.defaultcafe;

public class TestCafe{
	public static void main(String[]args){
		PancakeHouseMenu pancakes = new PancakeHouseMenu();
		SandwichPalaceMenu sandwiches = new SandwichPalaceMenu();
		CafeteriaMenu cafeteriaMenu = new CafeteriaMenu();
	
		Waitress waitress = new Waitress();
		waitress.printMenu(pancakes,sandwiches,cafeteriaMenu);
	}
}
