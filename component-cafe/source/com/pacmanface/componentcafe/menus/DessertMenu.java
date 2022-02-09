package com.pacmanface.componentcafe.menus;

import com.pacmanface.componentcafe.*;

public class DessertMenu extends Menu{
    public DessertMenu(){
        name = getClass().getSimpleName();
		description ="desserts";
		components.add(new MenuItem("Icecream dessert","three icecream ball on waffle",false,2.99)); 
		components.add(new MenuItem("fruits salad","salad with frech fruits",true,2.99));
		components.add(new MenuItem("Blueberry Pancakes and Chocolade","Pancakes made with French blueberries and chocolade",true,3.49));
		components.add(new MenuItem("Waffles with honey and peanuts","Waffles with your choice of blueberries and strawberries, honey, peanuts",false,3.59));
    }
}
