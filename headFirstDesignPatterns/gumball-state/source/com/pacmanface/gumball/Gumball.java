package com.pacmanface.gumball;

import com.pacmanface.gumball.states.*;

public class Gumball{
	State hasQuarter;
	State noQuarter;
	State sold;
	State soldOut;
	State winnerState;
	State currentState;
	int gums;

	public Gumball(int i){
		gums=i;
		hasQuarter = new HasQuarter(this);
		noQuarter = new NoQuarter(this);
		sold = new Sold(this);
		soldOut = new SoldOut(this);
		winnerState = new WinnerState(this);
		currentState = noQuarter;
	}
	
	public void setState(State state){
		currentState = state;
	}

	public State getHasQuarter() {
		return hasQuarter;
	}

	public State getNoQuarter() {
		return noQuarter;
	}

	public State getSold() {
		return sold;
	}

	public State getSoldOut() {
		return soldOut;
	}

	public State getWinnerState() {
		return winnerState;
	}
	
	public int getGums(){
		return gums;
	}

	public void setGums(int i){
		if(i>0){
			gums=i;
			currentState = noQuarter;
		}
	}

	public void deliver(){
		if(gums>0) {
			gums -= 1;
			System.out.println("Take your candy, please.");
			if(gums>0){
				currentState=winnerState;
				currentState.dispence();
			}
			currentState = noQuarter;
		}else{
			currentState = hasQuarter;
			ejectQuart();
			currentState = soldOut;
		}   
	}
	
	public void insertQuart(){
		currentState.insertQuart();
	}
	
	public void ejectQuart(){
		currentState.ejectQuart();
	}

	public void turnLever(){
		currentState.turnLever();
		currentState.dispence();
	}

	@Override
	public String toString() {
		return currentState.getClass().getSimpleName()+" "+gums;
	}
}
