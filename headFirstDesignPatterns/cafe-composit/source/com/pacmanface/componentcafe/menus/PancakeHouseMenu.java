package com.pacmanface.componentcafe.menus;

import com.pacmanface.componentcafe.*;

public class PancakeHouseMenu extends Menu{
	public PancakeHouseMenu(){
		name = getClass().getSimpleName();
		description = "for breakfast";
		menuComponents.add(new MenuItem("K&B Pancake Brakefast","Pancakes with scrambled eggs and toast",false,2.99)); 
		menuComponents.add(new MenuItem("Regular Pancake Breakfast","Pancakes with fried eggs and souce",false,2.99));
		menuComponents.add(new MenuItem("Blueberry Pancakes","Pancakes made with French blueberries",true,3.49));
		menuComponents.add(new MenuItem("Waffles","Waffles with your choice of blueberries and strawberries",true,3.59));
	}
}
