package com.pacmanface.cafe;

public class SandwichPalaceMenu{
	
	final MenuItem[] menu = new MenuItem[6];
	int number = 0;
	
	public SandwichPalaceMenu(){
		addItem("Vegetarian BLT","Fake bacon with lettuce & tomato on whole toast",true,2.99);
		addItem("BLT","Becon with lettuce & tomato on whole toast",false,2.99);
		addItem("Soup of the day","Soup of the day with side potato salad",false,3.29);
		addItem("Hot Dog","A hot dog with sourkraut, relish, onions, topped with cheese",false,3.05);
	}
	
	public void addItem(String name, String description, boolean isVegetarian, double price){
		MenuItem item = new MenuItem(name,description,isVegetarian,price);
		if(number<6){
			menu[number]=item;
			number++;
		}else System.out.println("no more place for dishes");
	}
	
	public MenuItem[] getMenu(){
		return menu;
	}
	
	public MenuIterator createIterator(){
		return new SandwichIterator(menu);
	}
}
