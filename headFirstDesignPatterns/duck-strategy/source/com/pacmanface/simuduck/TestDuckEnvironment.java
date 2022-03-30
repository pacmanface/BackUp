package com.pacmanface.simuduck;

public class TestDuckEnvironment{
	public static void main(String[]args){
		Duck[] ducks = {new BathroomDuck(),new BronzeDeskDuck(),new SimpleDuck(),new ToyDuck()};
		for(Duck duck:ducks){
			duck.display();
			duck.swim();
			duck.performFly();
			duck.performQuack();
		}
		
		Duck anotherDuck = ducks[0];
		anotherDuck.setFlyBehavior(new StoneFly());
		anotherDuck.performFly();
	}
}
