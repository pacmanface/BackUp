package com.pacmanface.defaultcafe;

import java.util.*;

public class CafeteriaMenu implements Menu{
	
	HashMap<String,MenuItem> menu = new HashMap<>();
	
	public CafeteriaMenu(){
		addItem("K&B Pancake Brakefast","Pancakes with scrambled eggs and toast",false,2.99);
		addItem("Regular Pancake Breakfast","Pancakes with fried eggs and souce",false,2.99);
		addItem("Blueberry Pancakes","Pancakes made with French blueberries",true,3.49);
		addItem("Waffles","Waffles with your choice of blueberries and strawberries",true,3.59);
		}
	
	public void addItem(String name, String description, boolean isVegetarian, double price){
		MenuItem item = new MenuItem(name,description,isVegetarian,price);
		menu.put(item.getName(),item);
	}
	
	public Iterator<MenuItem> createIterator(){
		return menu.values().iterator();
	}
}