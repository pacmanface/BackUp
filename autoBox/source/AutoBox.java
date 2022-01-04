package source;
/**
 * AutoBox
 */
public class AutoBox {
    Integer a;
    int b;
    
    void go(){
        //b=a;
        //a=b;
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {
        AutoBox autoBox = new AutoBox();
        autoBox.go();
    }
    
}