import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestHello {

    Hello hello = new Hello();

    @Test
    public void isItHelloJunit() {
        assertEquals(hello.getClass(),Hello.class);
    }

    @Test
    public void helloTest() {
        assertEquals(hello.hello(),"hello");
    }
}
