package com.pacmanface.componentcafe.testcafe;

import com.pacmanface.componentcafe.menus.*;
import com.pacmanface.componentcafe.*;

public class TestCafe{
	public static void main(String[]args){
		Component desserts = new DessertMenu();
		Component pancakes = new PancakeHouseMenu();
		Component sandwiches = new SandwichPalaceMenu();
		Component cafeteriaMenu = new CafeteriaMenu();
		Component allMenus = new AllMenu();
		pancakes.add(desserts);
		allMenus.add(pancakes);
		allMenus.add(sandwiches);
		allMenus.add(cafeteriaMenu);
		
	
		Waitress waitress = new Waitress(allMenus);
		//waitress.printMenu();
		waitress.printVegetarian();
	}
}
