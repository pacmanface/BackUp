package com.pacmanface.copatterns;

public class GooseAdapter implements Quack{
	private Goose goose;
	
	public GooseAdapter(Goose g){
		goose = g;
	}
	
	@Override
	public void quack(){
		goose.honk();
	}
}
