package com.pacmanface.componentcafe.menus;

import com.pacmanface.componentcafe.*;

public class SandwichPalaceMenu extends Menu{
	public SandwichPalaceMenu(){
		name = getClass().getSimpleName();
		description = "for lunch";
		components.add(new MenuItem("Vegetarian BLT","Fake bacon with lettuce & tomato on whole toast",true,2.99));
		components.add(new MenuItem("BLT","Becon with lettuce & tomato on whole toast",false,2.99));
		components.add(new MenuItem("Soup of the day","Soup of the day with side potato salad",false,3.29));
		components.add(new MenuItem("Hot Dog","A hot dog with sourkraut, relish, onions, topped with cheese",false,3.05));
	}
}
