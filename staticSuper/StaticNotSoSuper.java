public class StaticNotSoSuper extends StaticSuper{

    static int rand = 88;

    static {
        rand = 99;
        System.out.println("StaticNotSoSuper static block 1, rand = " + rand );
    }

    static{
        System.out.println("StaticNotSoSuper static block 2 rand = " + rand);
    }

    StaticNotSoSuper(){
        System.out.println("NotSoSuperStatic constructor, rand = " + rand);
    }

    

}
