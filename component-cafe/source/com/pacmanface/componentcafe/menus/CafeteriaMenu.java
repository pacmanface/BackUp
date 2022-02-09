package com.pacmanface.componentcafe.menus;

import com.pacmanface.componentcafe.*;

public class CafeteriaMenu extends Menu{
	public CafeteriaMenu() {
		name = getClass().getSimpleName();
		description = "for dinner";
		components.add(new MenuItem("BeafSteak","Steak, scrambled eggs and toast",false,2.99)); 
		components.add(new MenuItem("Pasta Marinara","pasta with seafood and souce",false,2.99));
		components.add(new MenuItem("Tofu noodles","rice noodles with tofu and vegetables",true,3.49));
	}
}
