package com.pacmanface.componentcafe.testcafe;

import com.pacmanface.componentcafe.menus.*;
import com.pacmanface.componentcafe.*;

public class TestCafe{
	public static void main(String[]args){
		MenuComponent desserts = new DessertMenu();
		MenuComponent pancakes = new PancakeHouseMenu();
		MenuComponent sandwiches = new SandwichPalaceMenu();
		MenuComponent cafeteriaMenu = new CafeteriaMenu();
		MenuComponent allMenus = new AllMenu();
		pancakes.add(desserts);
		allMenus.add(pancakes);
		allMenus.add(sandwiches);
		allMenus.add(cafeteriaMenu);
		
	
		Waitress waitress = new Waitress();
		waitress.printMenu(allMenus);
	}
}
