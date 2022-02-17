import java.rmi.Naming;

public class Client {
    
    public static void main(String[] args) {
        Client client = new Client();
        client.go();
    }

    void go(){
        try {
            MyRemote remote = (MyRemote) Naming.lookup("//localhost:1099/RemoteHello");
            String hi = remote.hello();
            System.out.println(hi);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
