package com.pacmanface.copatterns;

import com.pacmanface.copatterns.ducks.*;
import com.pacmanface.copatterns.factories.*;
import com.pacmanface.copatterns.lookat.*;

public class DuckSimulation{
	public static void main(String[]args){

		DuckSimulation sims = new DuckSimulation();

		Quack mallard;
		Quack redHead;
		Quack call;
		Quack rubber;
		Quack goose; 
		
		/*
		//test 1 - duck strategy & goose adapter
		mallard = new MallardDuck();
		redHead = new RedHeadDuck();
		call = new DuckCall();
		rubber = new RubberDuck();
		goose = new GooseAdapter(new Goose());
		sims.simulate(mallard, redHead, call, rubber, goose);
		*/

		/*
		//test_2 - counted duck factory simulation
		AbstractDuckFactory factory = new CountDuckFactory();
		AbstractGooseFactory gooseFactory = new GooseFactory();	
		mallard = factory.createMallardDuck();
		redHead = factory.createRedHeadDuck();
		call = factory.createDuckCall();
		rubber = factory.createRubberDuck();
		goose = gooseFactory.createGooseCounter();
		sims.simulate(mallard, redHead, call, rubber, goose);
		*/

		/*
		//test_3 counted birds flocktory
		AbstractDuckFactory factory = new CountDuckFactory();
		AbstractGooseFactory gooseFactory = new GooseFactory();	
		mallard = factory.createMallardDuck();
		redHead = factory.createRedHeadDuck();
		goose = gooseFactory.createGooseAdapter();
		Flock flock = new Flock();
		flock.addQuacker(mallard, redHead, goose);
		sims.simulate(flock);
		*/
		

		
		//test_4 duck observation
		Quackologist firstMan = new Quackologist();
		AbstractDuckFactory factory = new CountDuckFactory();
		AbstractGooseFactory gooseFactory = new GooseFactory();	
		mallard = factory.createMallardDuck();
		redHead = factory.createRedHeadDuck();
		goose = gooseFactory.createGooseAdapter();
		call = new DuckCall();
		rubber = new RubberDuck();
		Flock flock = new Flock();
		flock.addQuacker(mallard, redHead, goose, rubber, call);
		flock.registryObserver(firstMan);
		sims.simulate(flock);
		
	}
	
	public void simulate(Quack... quacker){
		for(Quack q: quacker) q.quack();
		System.out.println(QuackCounter.quackJob);
	}
}
