import java.io.*;
import java.net.*;

public class DailyAdviceClient {
    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }

    void go(){
        try {
            Socket socket = new Socket("127.0.0.1",4242);
            InputStreamReader is = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(is);
            String advice = reader.readLine();
            System.out.println("Today you have to " + advice);
            reader.close();
            socket.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
