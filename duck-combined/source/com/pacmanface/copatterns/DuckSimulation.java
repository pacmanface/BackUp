package com.pacmanface.copatterns;

import com.pacmanface.copatterns.ducks.*;
import com.pacmanface.copatterns.factories.*;
import com.pacmanface.copatterns.lookat.Quackologist;

public class DuckSimulation{
	public static void main(String[]args){
		DuckSimulation sims = new DuckSimulation();
		Quackologist firstMan = new Quackologist();
		Quackologist secondMan = new Quackologist();

		Quack mallard = new MallardDuck();
		Quack redHead = new RedHeadDuck();
		Quack call = new DuckCall();
		Quack rubber = new RubberDuck();
		Quack goose = new GooseAdapter(new Goose());
		sims.simulate(mallard, redHead, call, rubber, goose);
		
		/*
		Flock flock = new Flock();
		flock.addQuacker(mallard, redHead);
		sims.simulate(flock);
		*/
		
		AbstractDuckFactory factory = new CountDuckFactory();	
		mallard = factory.createMallardDuck();
		redHead = factory.createRedHeadDuck();
		call = factory.createDuckCall();
		rubber = factory.createRubberDuck();
		sims.simulate(mallard, redHead, call, rubber, goose);

		Flock flock2 = new Flock();
		flock2.addQuacker(mallard, redHead, goose);
		flock2.registryObserver(firstMan);
		sims.simulate(flock2);

		//sims.simulate(flock, flock2);



	}
	
	public void simulate(Quack... quacker){
		for(Quack q: quacker) q.quack();
		System.out.println(QuackCounter.quackJob);
	}
}
