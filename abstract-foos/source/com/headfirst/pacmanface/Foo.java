package com.headfirst.pacmanface;

class Foo extends FooAbstract {

    //final int yFoo;

    void doFoo(String s) {
        // native doFoo
        System.out.println("Native doFoo metod from "+getClass());    
    }

    @Override
    void makeFoo() {
        // TODO Auto-generated method stub
        System.out.println("Ovveriden makeFoo method from FooAbstract");
    }
    
}