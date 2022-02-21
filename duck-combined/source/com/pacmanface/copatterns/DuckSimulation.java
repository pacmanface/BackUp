package com.pacmanface.copatterns;

public class DuckSimulation{
	public static void main(String[]args){
		DuckSimulation sims = new DuckSimulation();
		
		
		Quack mallard = new MallardDuck();
		Quack redHead = new RedHeadDuck();
		Quack call = new DuckCall();
		Quack rubber = new RubberDuck();
		Quack goose = new GooseAdapter(new Goose());
		
		sims.simulate(mallard, redHead, call, rubber, goose);
		
		AbstractDuckFactory factory = new CountDuckFactory();
		
		mallard = factory.createMallardDuck();
		redHead = factory.createRedHeadDuck();
		call = factory.createDuckCall();
		rubber = factory.createRubberDuck();
		 
		sims.simulate(mallard, redHead, call, rubber, goose);
		System.out.println(QuackCounter.quackJob);
		
	}
	
	public void simulate(Quack... quacker){
		for(Quack q: quacker) q.quack();
	}
}
