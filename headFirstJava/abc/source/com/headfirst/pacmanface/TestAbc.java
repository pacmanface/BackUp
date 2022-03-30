package com.headfirst.pacmanface;

class TestAbc{
    
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        round(a);
        round(b);
        round(c);
    }

    static void round(A a){
        a.m1();
        a.m2();
        a.m3();
    }
}