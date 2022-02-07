package com.pacmanface.templatebeverage;

abstract class HotBeverage{

	public final void prepareReceipt(){
		boilWater();
		brewBeverage();
		pourInCup();
		if(isAddCondiment) addCondiment();
	}
	
	public void boilWater(){
		System.out.println("boil the water");
	}
	
	abstract void brewBeverage();
	
	public void pourInCup(){
		System.out.println("pour the beverage in the cup");
	}
	
	abstract void addCondiment();
	
	public boolean isAddCondiment(){
		return true;
	}
}
