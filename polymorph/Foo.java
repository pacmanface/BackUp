
class Foo extends FooAbstract {

    public static void main(String[] args) {
        FooAbstract fooAbstract = new Foo();    
        fooAbstract.doFoo();
        fooAbstract.makeConcreteFoo();
        System.out.println(fooAbstract.x);
    }
    
    
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