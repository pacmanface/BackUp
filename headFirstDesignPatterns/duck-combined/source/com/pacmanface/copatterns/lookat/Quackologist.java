package com.pacmanface.copatterns.lookat;

public class Quackologist implements QuackObserver {
    @Override
    public void update(QuackObservable q) {
        System.out.println("The object "+q.getClass().getSimpleName()+" just quacked!");
    }
}
