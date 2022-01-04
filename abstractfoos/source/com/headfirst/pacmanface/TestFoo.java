package com.headfirst.pacmanface;

public class TestFoo {

    public static void main(String[] args) {
        FooAbstract fooAbstract = new Foo();    
        fooAbstract.doFoo();
        fooAbstract.makeConcreteFoo();
        System.out.println(fooAbstract.x);
        System.out.println(Foo.z);
        
        
        //System.out.println(fooAbstract.yFoo);
        //System.out.println(a);
        //System.out.println(ABC);    
    }   
}
