package com.pacmanface.componentcafe.menus;

import com.pacmanface.componentcafe.*;

public class CafeteriaMenu extends Menu{
	public CafeteriaMenu() {
		name = getClass().getSimpleName();
		description = "for dinner";
		menuComponents.add(new MenuItem("BeafSteak","Steak, scrambled eggs and toast",false,2.99)); 
		menuComponents.add(new MenuItem("Pasta Marinara","pasta with seafood and souce",false,2.99));
		menuComponents.add(new MenuItem("Tofu noodles","rice noodles with tofu and vegetables",true,3.49));
	}
}
