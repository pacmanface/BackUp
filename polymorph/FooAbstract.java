abstract class FooAbstract implements FooInterface{
    int x = 7;

    abstract void makeFoo();

    @Override
    public void doFoo() {
        // TODO Auto-generated method stub
        System.out.println("doFoo overrided in abstract class FooAbstract!");
    }

    void makeConcreteFoo(){
        System.out.println("makeConcreteFoo in action!");
    }
}
